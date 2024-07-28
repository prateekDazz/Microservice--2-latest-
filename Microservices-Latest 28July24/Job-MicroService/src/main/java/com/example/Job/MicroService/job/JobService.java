package com.example.Job.MicroService.job;

import java.util.List;

import com.example.Job.MicroService.dto.JobDto;

public interface JobService {
	
	Job createJob(JobRequestDto jobRequestDto);
	List<JobDto> fetchAllJobs();
	JobDto fetchJobByJobId(Long jobId);
	Job updateJobByJobId(Long jobId,JobRequestDto jobRequestDto);
	Job deleteJobByJobId(Long jobId);
}
