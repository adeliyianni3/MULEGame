package MULE.models;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Abstract class no-args constructor adapter for gson.
 * @param <T> Object to be wrapped.
 */
public class InterfaceAdapter<T>
        implements JsonSerializer<T>, JsonDeserializer<T> {
    @Override
    public final JsonElement serialize(final T object, final Type interfaceType,
                                       final JsonSerializationContext context) {
        final JsonObject member = new JsonObject();
        member.addProperty("type", object.getClass().getName());
        member.add("data", context.serialize(object));
        return member;
    }

    @Override
    public final T deserialize(final JsonElement elem, final Type interfaceType,
                               final JsonDeserializationContext context)
            throws JsonParseException {
        final JsonObject member = (JsonObject) elem;
        final JsonElement typeString = get(member, "type");
        final JsonElement data = get(member, "data");
        final Type actualType = typeForName(typeString);
        return context.deserialize(data, actualType);
    }

    /**
     * Gets the type based on JsonElement.
     * @param typeElem JsonElement to be checked
     * @return Type of the provided element
     */
    private Type typeForName(final JsonElement typeElem) {
        try {
            return Class.forName(typeElem.getAsString());
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e);
        }
    }

    /**
     * Gets the JsonELement that was wrapped.
     * @param wrapper Wrapper of the JsonObject
     * @param memberName Name of thing to be unwrapped
     * @return JsonElement that was wrapped
     */
    private JsonElement get(final JsonObject wrapper, final String memberName) {
        final JsonElement elem = wrapper.get(memberName);
        if (elem == null) {
            throw new JsonParseException(
                    "no '" + memberName + "' member found in json file.");
        }
        return elem;
    }

}
