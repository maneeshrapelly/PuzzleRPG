package com.rpg;


import com.rpg.util.HelperUtil;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static com.rpg.util.Constants.NAME;
import static com.rpg.util.Constants.PLAYER_STATE_TXT_FILE;
import static com.rpg.util.Constants.POINTS;
import static com.rpg.util.Constants.ROOM;

import static org.junit.Assert.assertEquals;

public class CommandProcessorTest {
    static CommandProcessor processor;
    static HelperUtil util;
    //GameContainer container = GameContainer.getInstance();
    @BeforeClass
    public static void initialize() {
        processor = new CommandProcessor();
        util = new HelperUtil();
    }

    @Test
    public void testPlayerCharFromStatusFile() throws IOException {
        String text = NAME + "Luke" + "\n" +
                POINTS + 100 + "\n" +
                ROOM + 1;
        util.writeGameState(PLAYER_STATE_TXT_FILE, text);
        processor.createPlayerChar();
        assertEquals(processor.container.getPlayer().getHp(), 100);
        assertEquals(processor.container.getPlayer().getAccuracy(), 75);
        assertEquals(processor.container.getPlayer().getRoomNum(), 1);
        assertEquals(processor.container.getPlayer().getName(), "Luke");
    }
}
