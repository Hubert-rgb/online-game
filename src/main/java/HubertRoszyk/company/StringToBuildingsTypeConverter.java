package HubertRoszyk.company;

import HubertRoszyk.company.EntitiClass.BuildingsType;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StringToBuildingsTypeConverter implements Converter<String, BuildingsType> {
    @Override
    public BuildingsType convert(String source) {
        return BuildingsType.valueOf(source);
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
