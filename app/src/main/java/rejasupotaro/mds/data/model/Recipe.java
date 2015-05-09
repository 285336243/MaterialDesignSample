package rejasupotaro.mds.data.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@AutoValue
public abstract class Recipe extends Model {
    public static final Recipe dummy0 = new AutoValue_Recipe(
            "Chicken Soft Tacos",
            "Super easy, healthy tacos without using packaged taco seasoning. Spice-wise you just need some chili powder and ground cumin!",
            "http://upload.wikimedia.org/wikipedia/commons/a/a8/Tacos.jpg",
            Step.dummies(),
            "Updated at 05/06/2015",
            User.dummy());
    public static final Recipe dummy1 = new AutoValue_Recipe(
            "Bacon and Cheese Halusky",
            "A national dish of Slovakia! Halusky are like soft gnocchi, somewhat similar to German Spaetzle noodles. It's mixed with a slightly tangy, yet creamy Slovakian sheep cheese called Bryndza and topped with fried bacon. Bryndza can be hard to find outside of Slovakia, but you get pretty close by substituting another soft cheese like feta, cottage, goat cheese, etc. When I visited Slovakia, my friend introduced me to this dish. I had the chance to eat it with fresh brynza goat cheese in Spisské!",
            "http://upload.wikimedia.org/wikipedia/commons/4/45/La_Banquise_Poutine.jpg",
            Step.dummies(),
            "Updated at 06/06/2015",
            User.dummy());

    @JsonProperty("title")
    public abstract String title();

    @JsonProperty("description")
    public abstract String description();

    @JsonProperty("image_url")
    public abstract String imageUrl();

    @JsonProperty("steps")
    public abstract List<Step> steps();

    @JsonProperty("updated_at")
    public abstract String updatedAt();

    @JsonProperty("user")
    public abstract User user();

    @JsonCreator
    public static Recipe create(@JsonProperty("title") String title,
                                @JsonProperty("description") String description,
                                @JsonProperty("image_url") String imageUrl,
                                @JsonProperty("steps") List<Step> steps,
                                @JsonProperty("updated_at") String updatedAt,
                                @JsonProperty("user") User user) {
        return new AutoValue_Recipe(title, description, imageUrl, steps, updatedAt, user);
    }

    public static Recipe dummy() {
        int index = new SecureRandom().nextInt(2);
        switch (index) {
            case 1:
                return dummy1;
            default:
                return dummy0;
        }
    }

    public static List<Recipe> dummies() {
        return new ArrayList<Recipe>() {{
            add(Recipe.dummy());
            add(Recipe.dummy());
            add(Recipe.dummy());
            add(Recipe.dummy());
            add(Recipe.dummy());
            add(Recipe.dummy());
            add(Recipe.dummy());
            add(Recipe.dummy());
            add(Recipe.dummy());
            add(Recipe.dummy());
        }};
    }
}
