package com.example;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

   @GetMapping("/hello")
   @ResponseBody
   public String helloDemoRest() {
      return "Hello from Demo api !";
   }

   // path param http://localhost:8080/demo/api/33
   @GetMapping(value = "/{id}")
   public List<String> find(@PathVariable("id") Long id) {
      System.out.println( "id printing from pathVariable : " + id);
      return Arrays.asList("a", "b", "c");
   }

   // query param  http://localhost:8080/demo/api/item?data=1
   @GetMapping("/item")
   public @ResponseBody Item getItem(@RequestParam("data") String itemid){
       System.out.println( "itemId : " +  itemid);
         Item i = new Item();
         i.setId(1);
         i.setName("Item");
         i.setDescription("item description");
          return i;
   }

    @PostMapping(value = "/api/getAccountDetails")
    public ResponseEntity<Item> postItem(
            //@Valid
            @RequestBody final Item item,
            @RequestHeader final HttpHeaders headers
    ){
        System.out.println("Request obj :: ----> " + item);
        System.out.println("Header obj :: ----> " + headers);
        item.setId(item.getId() + 1);
        item.setName(item.getName() + "1");
        item.setDescription(item.getDescription() + "1");
        return new ResponseEntity<>(item, HttpStatus.OK);

    }











}
