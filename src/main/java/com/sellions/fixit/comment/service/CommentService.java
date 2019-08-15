package com.sellions.fixit.comment.service;

import com.sellions.fixit.comment.entity.Comment;
import com.sellions.fixit.comment.repository.CommentRepository;
import com.sellions.fixit.device.entity.Device;
import com.sellions.fixit.device.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class CommentService {
    private CommentRepository commentRepository;
    private DeviceService deviceService;

    public List<Comment> getAllCommentsByDeviceId(Long deviceID) {
        return commentRepository.getCommentsByDeviceId(deviceID);
    }

    public void insertComment(Long deviceID, Comment comment) {
        Device device = deviceService.getDeviceById(deviceID);
        comment.setCreateTimestamp(LocalDateTime.now());
        comment.setDevice(device);

        commentRepository.save(comment);
    }

    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }
}
