package com.sellions.fixit.parameter.service;

import com.sellions.fixit.comment.entity.Comment;
import com.sellions.fixit.device.entity.Device;
import com.sellions.fixit.device.service.DeviceService;
import com.sellions.fixit.parameter.entity.Parameter;
import com.sellions.fixit.parameter.repository.ParameterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ParameterService {
    private ParameterRepository parameterRepository;
    private DeviceService deviceService;

    public List<Parameter> getAllParametersByDeviceId(Long deviceID) {
        return parameterRepository.getParametersByDeviceId(deviceID);
    }

    public void insertParameter(Long deviceID, Parameter parameter) {
        Device device = deviceService.getDeviceById(deviceID);
        parameter.setCreateTimestamp(LocalDateTime.now());
        parameter.setDevice(device);

        parameterRepository.save(parameter);
    }

    public void deleteParameterById(Long id) {
        parameterRepository.deleteById(id);
    }
}
