package HubertRoszyk.company;

import HubertRoszyk.company.entiti_class.BuildingType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StringToBuildingTypeConverterTest {

    StringToBuildingsTypeConverter underTest;

    @BeforeEach
    void StringToBuildingsTypeConverter (StringToBuildingsTypeConverter underTest) {
        this.underTest = underTest;
    }

    @Test
    void shouldConvert() {
        //given
        String stringValue = "DEFENCE";
        //when
        BuildingType buildingType = underTest.convert(stringValue);
        //then
        assertThat(buildingType).isEqualTo(BuildingType.DEFENSE);
    }
}