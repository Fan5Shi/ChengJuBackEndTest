package com.example.test.web;

import com.example.test.api.EventService;
import com.example.test.api.enums.HttpCode;
import com.example.test.api.result.ResultDO;
import com.example.test.dao.dataobject.EventDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
//@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value="/events", method=RequestMethod.GET)
    @ResponseBody
    public ResultDO getAllEvents() {
        try {
            ResultDO resultDO = eventService.getAllEvents();
            return resultDO;
        } catch (Exception e) {
            return new ResultDO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    @RequestMapping(value="/events/bytime", method=RequestMethod.GET)
    @ResponseBody
    public ResultDO getEventsByTime() {
        try {
            ResultDO resultDO = eventService.getEventsByTime();
            return resultDO;
        } catch (Exception e) {
            return new ResultDO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    @RequestMapping(value="/events/search", method=RequestMethod.GET)
    @ResponseBody
    public ResultDO searchByName(@RequestParam(value="name") String name) {
        try {
            ResultDO resultDO = eventService.searchEventByName(name);
            return resultDO;
        } catch (Exception e) {
            return new ResultDO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    @RequestMapping(value="/events/{eventId}", method=RequestMethod.POST)
    @ResponseBody
    public ResultDO getEventById(@PathVariable("eventId") Integer eventId) {
        try {
            ResultDO resultDO = eventService.getEventByEventId(eventId);
            return resultDO;
        } catch (Exception e) {
            return new ResultDO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    @RequestMapping(value="/launch", method=RequestMethod.POST)
    @ResponseBody
    public ResultDO launchEvent(@RequestBody EventDO eventDO) {
        try {
            ResultDO resultDO = eventService.insert(eventDO);
            return resultDO;
        } catch (Exception e) {
            return new ResultDO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    @RequestMapping(value="/mine/{userId}/launched", method=RequestMethod.GET)
    @ResponseBody
    public ResultDO getLaunchedEvents(@PathVariable(value="userId") Integer userId) {
        try {
            ResultDO resultDO = eventService.getEventByUserId(userId);
            return resultDO;
        } catch (Exception e) {
            return new ResultDO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    @RequestMapping(value="/mine/{userId}/launched/delete", method=RequestMethod.DELETE)
    @ResponseBody
    public ResultDO deleteLaunchedEvent(@PathVariable(value="userId") Integer userId,
                                        @RequestParam(value="eventId") Integer eventId) {
        try {
            ResultDO resultDO = eventService.delete(eventId, userId);
            return resultDO;
        } catch (Exception e) {
            return new ResultDO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    @RequestMapping(value="/mine/{userId}/launched/update", method=RequestMethod.PUT)
    @ResponseBody
    public ResultDO updateLaunchedEvent(@RequestBody EventDO eventDO) {
        try {
            ResultDO resultDO = eventService.update(eventDO);
            return resultDO;
        } catch (Exception e) {
            return new ResultDO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }
}
