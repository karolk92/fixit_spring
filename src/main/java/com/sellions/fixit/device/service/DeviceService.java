package com.sellions.fixit.device.service;

import com.sellions.fixit.device.entity.Device;
import com.sellions.fixit.device.repository.DeviceRepository;
import com.sellions.fixit.enums.Condition;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DeviceService {
    private DeviceRepository deviceRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).get();
    }

    public void insertDevice(Device device) {
        deviceRepository.save(device);
    }

    public void updateDevice(Device device) {
        Device result = deviceRepository.findById(device.getId()).get();
        result.setName(device.getName());
        result.setCategory(device.getCategory());
        result.setDateOfProduction(device.getDateOfProduction());
        result.setCondition(device.getCondition());
        result.setComments(device.getComments());
        result.setParameters(device.getParameters());

        deviceRepository.save(result);
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    public boolean reportMalfunction(Long id) {
        Device result = deviceRepository.findById(id).get();

        if (result.getCondition().equals(Condition.valueOf("WORKING"))) {
            result.setCondition(Condition.BROKEN);
            updateDevice(result);
            return true;
        } else {
            return false;
        }
    }

    public boolean reportMalfunctionRemoval(Long id) {
        Device result = deviceRepository.findById(id).get();

        if (result.getCondition().equals(Condition.valueOf("BROKEN"))) {
            result.setCondition(Condition.WORKING);
            updateDevice(result);
            return true;
        } else {
            return false;
        }
    }
}
