package com.sellions.fixit.device.controller;

import com.sellions.fixit.comment.entity.Comment;
import com.sellions.fixit.comment.service.CommentService;
import com.sellions.fixit.device.entity.Device;
import com.sellions.fixit.device.service.DeviceService;
import com.sellions.fixit.parameter.entity.Parameter;
import com.sellions.fixit.parameter.service.ParameterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/devices")
public class DeviceController {
    private DeviceService deviceService;
    private CommentService commentService;
    private ParameterService parameterService;

    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devices = deviceService.getAllDevices();

        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Device> getDeviceByID(@PathVariable("id") Long id) {
        Device device = deviceService.getDeviceById(id);

        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertDevice(@RequestBody Device device) {
        deviceService.insertDevice(device);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateDevice(@RequestBody Device device) {
        deviceService.updateDevice(device);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable("id") Long id) {
        deviceService.deleteDevice(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/comments")
    public ResponseEntity<List<Comment>> getAllCommentsByDeviceId(@PathVariable("id") Long deviceID) {
        List<Comment> result = commentService.getAllCommentsByDeviceId(deviceID);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/parameters")
    public ResponseEntity<List<Parameter>> getAllParametersByDeviceId(@PathVariable("id") Long deviceID) {
        List<Parameter> result = parameterService.getAllParametersByDeviceId(deviceID);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/parameters")
    public ResponseEntity<Void> addParameter(@PathVariable("id") Long deviceID, @RequestBody Parameter parameter) {
        parameterService.insertParameter(deviceID, parameter);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/comments")
    public ResponseEntity<Void> addComment(@PathVariable("id") Long deviceID, @RequestBody Comment comment) {
        commentService.insertComment(deviceID, comment);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/report-malfunction")
    public ResponseEntity<Boolean> reportMalfunction(@PathVariable("id") Long id) {
        Boolean isReported = deviceService.reportMalfunction(id);

        return new ResponseEntity<>(isReported, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/report-malfunction-removal")
    public ResponseEntity<Boolean> reportMalfunctionRemoval(@PathVariable("id") Long id) {
        Boolean isReported = deviceService.reportMalfunctionRemoval(id);

        return new ResponseEntity<>(isReported, HttpStatus.OK);
    }
}
