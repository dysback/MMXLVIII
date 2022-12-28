package org.dy.mmxlviii;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController 
class ws2048 {



    @RequestMapping(method=RequestMethod.GET, path="/test/{number}")  
    public String helloWorld(@PathVariable Integer number)  
    {  
        MmxlviiiApplication.lista.add(number);  
        return MmxlviiiApplication.printItems();
        
    }

    @RequestMapping(method=RequestMethod.GET, path="/start-game")  
    public int[][] StartGame()  
    {  
        MmxlviiiApplication.game = new Game();  
        return MmxlviiiApplication.game.getTable();        
    }

    @RequestMapping(method=RequestMethod.GET, path="/move-left") 
    public int[][] MoveLeft()  
    {  
        MmxlviiiApplication.game.moveLeft();
        return MmxlviiiApplication.game.getTable();
        
        
    }

    @RequestMapping(method=RequestMethod.GET, path="/move-right") 
    public int[][] MoveRight()  
    {  
        MmxlviiiApplication.game.moveRight();
        return MmxlviiiApplication.game.getTable();
        
        
    }


}