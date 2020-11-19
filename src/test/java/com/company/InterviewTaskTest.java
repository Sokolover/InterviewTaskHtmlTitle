package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class InterviewTaskTest {
    @Test
    void testMainViaEpamUrl() throws IOException {
        String[] arg = {"https://www.epam.com/"};
        String title = InterviewTask.findUrlTitle(arg);
        Assertions.assertEquals("EPAM | Enterprise Software Development, Design & Consulting", title);
    }
}
