package com.trueprogrammers.youtubearchive.controller

import com.trueprogrammers.youtubearchive.models.entity.VideoArchive
import com.trueprogrammers.youtubearchive.service.VideoArchiver
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class VideoController(
    private val videoArchiver: VideoArchiver
) {
    @PostMapping("/video")
    fun archiveVideo(@RequestParam url: String): String {
        return videoArchiver.archiveVideo(url)
    }

    @GetMapping("/video/archives")
    fun searchVideoArchives(
        @RequestParam(value = "page", required = false, defaultValue = "0") page: Int,
        @RequestParam(value = "size", required = false, defaultValue = "10") size: Int,
        @RequestParam(required = false) query: String?
    ): List<VideoArchive> {
        return videoArchiver.findVideosByQuery(page, size, query)
    }

    @GetMapping("/video/archives/{id}")
    fun getVideoArchiveById(@PathVariable id: String): VideoArchive {
        return videoArchiver.findVideoById(id)
    }
}