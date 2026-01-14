
import com.example.remotemediator.data.remote.MealDto
import com.google.gson.annotations.SerializedName

data class MealsResponseDto(
    @SerializedName("meals") val meals: List<MealDto>?
)


