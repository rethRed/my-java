package _shared.domain;
import java.util.UUID;

public abstract class AggregateRoot {
    
    private String _id;

    public String getId() {
        return _id;
    }

    public AggregateRoot( String id) {
        this._id = id;
    }

    public AggregateRoot() {
        UUID uuid = UUID.randomUUID();
        this._id = uuid.toString();
    }



}
