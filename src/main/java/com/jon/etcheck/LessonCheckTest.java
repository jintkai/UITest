package com.jon.etcheck;

import org.testng.annotations.Test;

/**
 * Created by jon on 2017/7/23.
 */
public class LessonCheckTest {

    LessonCheck lessonCheck = new LessonCheck();

    @Test
    public void testLessonCheck(){
        lessonCheck.checkLesson();
    }
}
