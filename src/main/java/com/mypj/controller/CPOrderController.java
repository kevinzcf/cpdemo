package com.mypj.controller;

import java.util.List;

import javax.jws.WebParam;
import javax.validation.Valid;

import com.mypj.domain.CPOrder;
import com.mypj.repository.CPOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.mypj.domain.Result;
import com.mypj.service.CPOrderService;
import com.mypj.utils.ResultUtils;

/**
 * @author kevinzcf
 */
@Controller
public class CPOrderController {

    private final static Logger logger = LoggerFactory.getLogger(CPOrderController.class);

    @Autowired
    private CPOrderRepository cpOrderRepository;

    @Autowired
    private CPOrderService cpOrderService;

    @GetMapping("/")
    public String showPage(Model model, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("data", cpOrderRepository.findAll(new PageRequest(page,4)));
        model.addAttribute("currentPage",page);
        return "index";
    }

    /**
     * find all cpOrder
     *
     * @return
     */
    @GetMapping(value = "/orderlist")
    public List<CPOrder> orderlist() {
        logger.info("orderlist");

        return cpOrderRepository.findAll();
    }

    /**
     * add a CPOrder
     *
     * @return
     */
    @PostMapping(value = "/order")
    public Result<CPOrder> addOrder(@Valid CPOrder CPOrder, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        CPOrder.setItemName(CPOrder.getItemName());
        CPOrder.setItemDescriptions(CPOrder.getItemDescriptions());

        return ResultUtils.success(cpOrderRepository.save(CPOrder));
    }

    @GetMapping(value = "/order/{id}")
    public CPOrder findOneOrder(@PathVariable("id") Integer id) {
        return cpOrderService.findOne(id);
    }

    // delete
    @DeleteMapping(value = "/order/{id}")
    public void deleteOrder(@PathVariable("id") Integer id) {
        cpOrderRepository.deleteById(id);
    }

    @GetMapping(value = "/createOrders/{count}")
    public String createOrders(@PathVariable("count") Integer count) {
        logger.info("createOrders");
        cpOrderService.createOrders(count);
        return "redirect:/";
    }

    @GetMapping(value = "/cleanOrders")
    public void cleanOrders() {
        logger.info("cleanOrders");
        cpOrderService.cleanOrders();
    }

    @GetMapping(value = "/apply")
    public String apply(Integer id) {
        cpOrderService.apply(id);
        return "redirect:/";
    }
}
