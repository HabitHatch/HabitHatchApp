package com.habithatch.demo.repositories

import androidx.compose.ui.graphics.Color
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.core.config.HabitPriorityProvider
import com.habithatch.demo.core.config.HabitStatusProvider
import com.habithatch.demo.core.query.HabitFilter
import com.habithatch.demo.core.query.HabitQuery
import com.habithatch.demo.data.daos.HabitDao
import com.habithatch.demo.data.entities.HabitEntity
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.mappers.HabitMapper
import com.habithatch.demo.data.models.HabitModel
import com.habithatch.demo.data.models.UserModel
import com.habithatch.demo.data.repositories.HabitRepository
import com.habithatch.demo.data.repositories.UserRepository
import io.mockk.coEvery
import io.mockk.mockk
import java.util.UUID
import javax.inject.Inject
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class HabitRepositoryTest {
    private lateinit var statusProvider: HabitStatusProvider
    private lateinit var priorityProvider: HabitPriorityProvider
    private lateinit var habitDao: HabitDao
    private lateinit var habitRepository: HabitRepository
    private lateinit var userRepository: UserRepository
    private lateinit var habitMapper: HabitMapper

    private val matchAllBuilder = HabitFilter.Builder.matchAllBuilder(priorityProvider, statusProvider)

    private val normalPriority =
        HabitModel.Priority(
            labelRes = "Normal",
            importance = HabitModel.Priority.Importance.Normal,
            iconResourceId = 1,
            getColor = { Color.Green },
        )
    private val highPriority =
        HabitModel.Priority(
            labelRes = "High",
            importance = HabitModel.Priority.Importance.High,
            iconResourceId = 2,
            getColor = { Color.Red },
        )
    private val inProgressStatus =
        HabitModel.Status(
            label = "In Progress",
            stepNumber = 10,
            isDone = false,
        )
    private val doneStatus =
        HabitModel.Status(
            label = "Done",
            stepNumber = 20,
            isDone = true,
        )
    private val userId = UUID.randomUUID()

    @Inject
    lateinit var habitFactory: HabitModel.Factory

    @Before
    fun setup() {
        habitDao = mockk()

        statusProvider =
            object : HabitStatusProvider {
                override val statuses = setOf(inProgressStatus, doneStatus)
                override val defaultStatus = inProgressStatus
            }

        priorityProvider =
            object : HabitPriorityProvider {
                override val priorities = setOf(normalPriority, highPriority)
                override val defaultPriority = normalPriority
            }

        habitMapper = HabitMapper(statusProvider, priorityProvider, habitFactory)

        userRepository = mockk()
        coEvery { userRepository.getUser() } returns
            flowOf(
                UserModel(
                    uuid = userId,
                    pet =
                        Pet(
                            id = 1,
                            nameRes = "",
                            coverImage = 1,
                        ),
                ),
            )
        habitRepository =
            HabitRepository(
                habitDao = habitDao,
                habitMapper = habitMapper,
            )
        coEvery { habitDao.update(any(), any(), any(), any()) } returns Unit
    }

    private fun asEntity(habit: HabitModel): HabitEntity = habitMapper.asEntity(habit)

    private suspend fun assertFilterMatches(
        matching: Collection<HabitModel>,
        notMatching: Collection<HabitModel>,
        filterBuilder: HabitFilter.Builder,
    ) {
        val habitQuery =
            HabitQuery(
                filterBuilder = filterBuilder,
                sortOptions = emptyList(),
                defaultComparator = compareBy { it.title.lowercase() },
            )
        val habitEntities = (matching + notMatching).map(::asEntity)
        coEvery { habitDao.getAll() } returns flowOf(habitEntities)

        val result: List<HabitModel> = habitRepository.search(habitQuery).first()
        assertThat(result).containsExactlyElementsIn(matching)
    }

    private suspend fun getQueriedHabits(
        habits: List<HabitModel>,
        habitQuery: HabitQuery,
    ): List<HabitModel> {
        val habitEntities = habits.map(::asEntity)
        coEvery { habitDao.getAll() } returns flowOf(habitEntities)

        return habitRepository.search(habitQuery).first()
    }

    @Test
    fun `getQueriedHabits() should return all habits when no filter is applied`() {
        runBlocking {
            // Arrange
            val matchingHabits =
                listOf(
                    habitFactory.createDraft(userId, inProgressStatus, normalPriority, "match 1"),
                    habitFactory.createDraft(userId, inProgressStatus, normalPriority, "match 2"),
                    habitFactory.createDraft(userId, doneStatus, normalPriority, "match 3"),
                )

            // Act & Assert
            assertFilterMatches(matching = matchingHabits, notMatching = emptyList(), matchAllBuilder)
        }
    }

    @Test
    fun `getQueriedHabits() should return habits matching the search query`() {
        runBlocking {
            // Arrange
            val matchingHabits =
                listOf(
                    habitFactory.createDraft(userId, inProgressStatus, normalPriority, "match 1"),
                    habitFactory.createDraft(userId, inProgressStatus, normalPriority, "match 2"),
                )
            val notMatchingHabits =
                listOf(
                    habitFactory.createDraft(userId, inProgressStatus, normalPriority, "not matching"),
                )
            val filterBuilder =
                matchAllBuilder
                    .setSearchQuery("Habit")

            // Act & Assert
            assertFilterMatches(matchingHabits, notMatchingHabits, filterBuilder)
        }
    }

    @Test
    fun `getQueriedHabits() should return no habits when search query does not match`() {
        runBlocking {
            // Arrange
            val notMatchingHabits =
                listOf(
                    habitFactory.createDraft(userId, inProgressStatus, normalPriority, "not matching 1"),
                    habitFactory.createDraft(userId, inProgressStatus, normalPriority, "not matching 2"),
                )

            val filterBuilder =
                matchAllBuilder
                    .setSearchQuery("nothing")

            // Act & Assert
            assertFilterMatches(emptyList(), notMatchingHabits, filterBuilder)
        }
    }

    @Test
    fun `getQueriedHabits() should return habits matching priorities`() =
        runBlocking {
            // Arrange
            val matchingHabits =
                listOf(
                    habitFactory.createDraft(userId, inProgressStatus, normalPriority, "Habit 1"),
                    habitFactory.createDraft(userId, doneStatus, normalPriority, "Habit 2"),
                )
            val notMatchingHabits =
                listOf(habitFactory.createDraft(userId, inProgressStatus, highPriority, "Not Matching"))

            val filterBuilder =
                matchAllBuilder
                    .priorityVisibility(highPriority, false)

            // Act & Assert
            assertFilterMatches(matchingHabits, notMatchingHabits, filterBuilder)
        }

    @Test
    fun `getQueriedHabits() should return habits sorted by comparator`() =
        runBlocking {
            // Arrange
            val habits =
                listOf(
                    habitFactory.createDraft(userId, inProgressStatus, normalPriority, "A Habit"),
                    habitFactory.createDraft(userId, inProgressStatus, highPriority, "B Habit"),
                    habitFactory.createDraft(userId, inProgressStatus, normalPriority, "C Habit"),
                )

            val habitQuery =
                HabitQuery(
                    filterBuilder = matchAllBuilder,
                    sortOptions = emptyList(),
                    defaultComparator = compareBy { it.priority.importance },
                )

            val expectedSortedHabits =
                habits.sortedWith(
                    compareBy<HabitModel> { it.priority.importance }.thenBy { it.title },
                )

            // Act
            val result = getQueriedHabits(habits, habitQuery)

            // Assert
            assertThat(result).isEqualTo(expectedSortedHabits)
        }

    @Test
    fun `getQueriedHabits() should return filtered and sorted habits`() =
        runBlocking {
            // Arrange
            val matchingHabits =
                listOf(
                    habitFactory.createDraft(userId, inProgressStatus, normalPriority, "A Habit 1"),
                    habitFactory.createDraft(userId, inProgressStatus, highPriority, "B Habit 2"),
                )

            val notMatchingHabits =
                listOf(
                    habitFactory.createDraft(userId, doneStatus, normalPriority, "Habit 3"),
                )

            val filterBuilder =
                HabitFilter
                    .Builder
                    .matchAllBuilder(priorityProvider, statusProvider)
                    .statusVisibility(doneStatus, false)

            val habitQuery =
                HabitQuery(
                    filterBuilder = filterBuilder,
                    sortOptions = emptyList(),
                    defaultComparator = compareBy { it.priority.importance },
                )
            val sortedHabits =
                matchingHabits.sortedWith(
                    compareBy<HabitModel> { it.priority.importance }.thenBy { it.title.lowercase() },
                )

            val allHabits = matchingHabits + notMatchingHabits

            // Act
            val result = getQueriedHabits(allHabits, habitQuery)

            // Assert
            assertThat(result).isEqualTo(sortedHabits)
        }
}
