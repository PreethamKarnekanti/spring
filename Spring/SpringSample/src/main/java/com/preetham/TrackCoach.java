package com.preetham;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;
    public TrackCoach(){}
    public TrackCoach(FortuneService theFortuneService)
    {
        fortuneService=theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it:"+fortuneService.getFortune();
    }
    public void init()
    {
        System.out.println("TrackCoach init method");
    }
    public void destroy()
    {
        System.out.println("TrackCoach destroy method");
    }
}
