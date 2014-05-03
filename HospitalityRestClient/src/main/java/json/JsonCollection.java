package json;

import model.HospitalityEntity;

import javax.ws.rs.ext.Provider;
import java.util.Collection;

/**
 * Created by Gleichmut on 5/3/2014.
 */
@Provider
public class JsonCollection extends JsonProvider<Collection<? extends HospitalityEntity>> {
}
