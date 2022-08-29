package HubertRoszyk.company;

import HubertRoszyk.company.entiti_class.BuildingType;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToBuildingsTypeConverter implements Converter<String, BuildingType> {
    @Override
    public BuildingType convert(String source) {
        return BuildingType.valueOf(source);
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }
}
