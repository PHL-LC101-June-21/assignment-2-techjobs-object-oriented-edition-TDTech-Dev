package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job = new Job();
        Job nJob = new Job();
        assertNotEquals(job.getId(), nJob.getId());
    }

    @Test
    public void testJobConstructorSetAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof  Employer);
        assertTrue(job.getLocation() instanceof  Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof  CoreCompetency);

        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getEmployer().getValue(),"ACME");
        assertEquals(job.getLocation().getValue(), "Desert");
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {

        Job job = new Job();
        Job nJob = new Job();
        assertFalse(job.equals(nJob));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job nJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', nJob.toString().charAt(0));
        assertEquals('\n', nJob.toString().charAt(nJob.toString().length() - 1));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job nJob = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("\n" +
                        "ID: " + nJob.getId() + "\n" +
                        "Name: " + nJob.getName() + "\n" +
                        "Employer: " + nJob.getEmployer() + "\n" +
                        "Location: " + nJob.getLocation() + "\n" +
                        "Position Type: " + nJob.getPositionType() + "\n" +
                        "Core Competency: " + nJob.getCoreCompetency() + "\n", nJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job nJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        assertEquals("\n" +
                "ID: " + nJob.getId() + "\n" +
                "Name: Data not available" + "\n" +
                "Employer: Data not available" + "\n" +
                "Location: Data not available" + "\n" +
                "Position Type: Data not available" + "\n" +
                "Core Competency: Data not available" + "\n", nJob.toString());
    }
}
