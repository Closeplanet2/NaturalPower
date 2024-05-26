package com.pandapulsestudios.naturalpower.VariableTests;

import com.pandapulsestudios.naturalpower.Enum.Normal.PlantType;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import com.pandapulsestudios.pulsecore.NBTAPI.Enums.PersistentDataTypes;
import com.pandapulsestudios.pulsecore.VariableAPI.Interface.PulseVariableTest;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

@PulseAutoRegister
public class PlantTypeVariableTest implements PulseVariableTest {
    @Override
    public PersistentDataTypes PersistentDataType() { return PersistentDataTypes.STRING; }

    @Override

    public boolean IsType(Object variable) {
        try{
            var test = PlantType.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(PlantType.class);
        data.add(PlantType[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return PlantType.valueOf(serializedData.toString());
    }

    @Override
    public Object ReturnDefaultValue() { return PlantType.CARROTS; }

    @Override
    public List<String> TabData(List<String> list, String s) {
        var data = new ArrayList<String>();
        for(var x : PlantType.values()) if(x.name().contains(s)) data.add(x.name());
        return data;
    }
}
