package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloContainer {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
        /*
        * 
        *   template안에 hello라는 거를 찾아라
        *   ViewResolver 가 찾아서 세팅해준다. resources:templates/ + ViewName + .html
        * 
        */
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){

        //ResponseBody 응답부에 직접 넣어주겠다.
        //뷰 이런게 없고 고대로 내려감 | 데이터를 그대로 내려줍니다.
        //이거 쓸 일 거의 없음

        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();//cmd shift enter 자동완성
        hello.setName(name);
        //객체를 넘겼으
        //json이라는 방식으로 넘어옵니다 
        //xml은 무겁고 열고닫고 귀찮아 json은 simple해 최근에는 json으로 통일됨
        /*
             ResponseBody 붙었다 그러면 http에 그냥 이 넘겨야겠구나 문자가 아니고 객체야
             문자는 그냥 줘버렸으
             객체네 그럼 스프링에서 기본으로는 JSON방식으로 데이터를 만들어서 반환하곘다.
             HttpMessageConverter 가 동작합니다. 그럼 얘가
             JsonConverter(MappingJackson2HttpMessageConverter) StringConverter 로 문자냐 객체냐 따라 사용된다. viewresolver 처럼
             실무에서 많이보는 JSON 라이브러리 = jackson 구글에 gson도 있음
             부트의 선택은 Jackson
         */
        return hello;
    }
    static class Hello{
        private String name;

        //getter setter == alt + insert
        //자바 빈 규약 오랜만에 들읐다. 메소드를 통해 접근 프로퍼티 접근방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
