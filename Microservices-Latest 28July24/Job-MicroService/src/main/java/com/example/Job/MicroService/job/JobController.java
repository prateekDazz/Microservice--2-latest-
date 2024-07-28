package com.example.Job.MicroService.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Job.MicroService.dto.JobDto;

import java.util.List;

@RestController
@RequestMapping("/api/job")
public class JobController {

	private static Logger logger = LoggerFactory.getLogger(JobController.class);
	@Autowired
	private JobService jobService;

	@PostMapping
	public ResponseEntity<Job> createJob(@RequestBody JobRequestDto jobRequestDto) {
		logger.info("JobController.java :: inside createJob() {} with jobRequestDto as " + jobRequestDto);
		Job job = jobService.createJob(jobRequestDto);
		return ResponseEntity.ok(job);
	}

	@GetMapping("/{id}")

	public ResponseEntity<JobDto> fetchJobByjobId(@PathVariable("id") Long id) {
		logger.info("JobController.java :: inside fetchJobByjobId() {} with jobId as " + id);
		JobDto jobDto = jobService.fetchJobByJobId(id);
		return ResponseEntity.ok(jobDto);
	}

	@GetMapping
	public ResponseEntity<List<JobDto>> fetchAllJobs() {
		logger.info("JobController.java :: inside fetchAllJobs() {}");

		List<JobDto> jobList = jobService.fetchAllJobs();
		return ResponseEntity.ok(jobList);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Job> updateJobByjobId(@PathVariable("id") Long id, @RequestBody JobRequestDto jobRequestDto) {
		logger.info("JobController.java :: inside fetchJobByjobId() {} with jobId as " + id);
		Job job = jobService.updateJobByJobId(id, jobRequestDto);
		return ResponseEntity.ok(job);
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<Job> deleteJobByJobId(@PathVariable("id") Long id) {
		logger.info("JobController.java :: inside fetchJobByjobId() {} with jobId as " + id);
		Job job = jobService.deleteJobByJobId(id);
		return ResponseEntity.ok(job);
	}

}
