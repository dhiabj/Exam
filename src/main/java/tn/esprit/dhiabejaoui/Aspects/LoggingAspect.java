package tn.esprit.dhiabejaoui.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

//	@Before("execution(* tn.esprit.dhiabejaoui.controllers.*.ajouter*(..))")
//	public void logMethodEntry(JoinPoint joinPoint) {
//
//		String name = joinPoint.getSignature().getName();
//
//		log.info("Début Exécution :" + name );
//	}

    @After("execution(* tn.esprit.dhiabejaoui.controllers.*.get*(..))")
    public void apres(JoinPoint thisJoinPoint) {
        log.info("Out of the method (After)" + thisJoinPoint.getSignature().getName());
    }


//	@After("execution(* tn.esprit.dhiabejaoui.services.*.*(..))")
//	public void logMethodExit(JoinPoint joinPoint) {
//
//		String name = joinPoint.getSignature().getName();
//
//		log.info("Out of method :" + name );
//	}

}