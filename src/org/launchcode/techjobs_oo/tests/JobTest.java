package org.launchcode.techjobs_oo.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

public class JobTest {
    Job job1;
    Job job2;
    Job job3;
    Job job4;
    Job job5;
    String testString;
    String emptyTestString;

    @Before
    public void createTestJob(){
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType ("Quality Control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType ("Quality Control"), new CoreCompetency("Persistence"));
        job5 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType ("Quality Control"), new CoreCompetency("Persistence"));
        testString = job3.toString();
        emptyTestString = job5.toString();

    }
    @Test
    public void testSettingJobId(){
        assertNotEquals(job1.getId(), job2.getId());
        assertTrue(job1.getId()+1 == job2.getId() || job1.getId()-1 == job2.getId());
    }
    @Test
    public void testJobContructorSetsAllFields(){
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality Control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality(){
        assertFalse(job3.equals(job4));
    }
    @Test
    public void testToStringForBlankLines(){
        assertTrue(testString.startsWith("\n"));
        assertTrue(testString.endsWith("\n"));
    }
    @Test
    public void testToStringLabelsAndData(){
        assertTrue(testString.contains("ID: "));
        assertTrue(testString.contains("Name: "));
        assertTrue(testString.contains("Employer: "));
        assertTrue(testString.contains("Location: "));
        assertTrue(testString.contains("Position Type: "));
        assertTrue(testString.contains("Core Competency: "));
    }
    @Test
    public void testToStringModifiesEmptyField(){
        assertTrue(emptyTestString.toString().contains("Data not available"));
    }

}
