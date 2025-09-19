package com.decision;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class testDialog {

    @Test
    public void testGetterSetter(){
        Dialog d = new Dialog();
        d.setId("escalar");
        d.setTexto("Te caes, ahora tienes dolor de espalda.");
        d.setOptions(Map.of(
                "Fin", "Final"));


        assertEquals("escalar", d.getId());
        assertEquals("Te caes, ahora tienes dolor de espalda.",d.getText());
        assertEquals(Map.of("Fin", "Final"),d.getOptions());
    }

}
