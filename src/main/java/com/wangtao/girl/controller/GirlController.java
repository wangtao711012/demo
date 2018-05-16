package com.wangtao.girl.controller;

import com.wangtao.girl.domain.Girl;
import com.wangtao.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

/**@author wangtao
 * @describe 查询女生信息列表
 *
 *
 */
@Autowired
public GirlRepository girlRepository;
@RequestMapping(value = "/girllist",method = RequestMethod.GET)
public List<Girl> girlList(){
    return girlRepository.findAll();


}

@GetMapping("/deleteone/{id}")
    public List<Girl> deleteone(@PathVariable Integer id){
    girlRepository.deleteById(id);
    return  girlRepository.findAll();

}

@RequestMapping(value = "/addone",method = RequestMethod.GET)
public Girl addgirl(@RequestParam Integer id,@RequestParam String name){
Girl girl=new Girl();
girl.setId(id);
girl.setName(name);
return girlRepository.save(girl);

//return girlRepository.findAll();
}


@RequestMapping(value="/update",method = RequestMethod.GET)
    public void update(@RequestParam Integer id,
                       @RequestParam String name){

        Girl girl=new Girl();
        girl.setId(id);
        girl.setName(name);

        girlRepository.save(girl);

}


@GetMapping("/findbyname/{name}")
    public List<Girl> findByName(@PathVariable String name){
    return girlRepository.findByName(name);
}

}
