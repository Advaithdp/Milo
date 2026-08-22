package dev.advaithdp.milo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.ColumnInfo
import androidx.room.Index

enum class Role {
    PRIMARY, SECONDARY
}

@Entity(
    tableName = "exercise_muscles",
    foreignKeys = [
        ForeignKey(
            entity = Exercise::class,
            parentColumns = ["id"],
            childColumns = ["exercise_id"],
            onDelete = ForeignKey.RESTRICT
        ),
        ForeignKey(
            entity = Muscle::class,
            parentColumns = ["id"],
            childColumns = ["muscle_id"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [
        Index(value = ["exercise_id", "muscle_id"], unique = true),
        Index(value = ["muscle_id"])
    ]
)
data class ExerciseMuscle(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val role: Role,
    @ColumnInfo(name = "exercise_id")
    val exerciseId: Long,
    @ColumnInfo(name = "muscle_id")
    val muscleId: Long
)