package dev.advaithdp.milo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.ColumnInfo
import androidx.room.Index

enum class EquipmentType {
    BARBELL, DUMBBELL, MACHINE, BODYWEIGHT
}

@Entity(
    tableName = "exercises",
    foreignKeys = [
        ForeignKey(
            entity = Location::class,
            parentColumns = ["id"],
            childColumns = ["location_id"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [
        Index(value = ["name"], unique = true),
        Index(value = ["location_id"])
    ]
)
data class Exercise(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    @ColumnInfo(name = "movement_pattern")
    val movementPattern: String,
    @ColumnInfo(name = "machine_tag")
    val machineTag: String? = null,
    @ColumnInfo(name = "equipment_type")
    val equipmentType: EquipmentType,
    @ColumnInfo(name = "location_id")
    val locationId: Long? = null
)