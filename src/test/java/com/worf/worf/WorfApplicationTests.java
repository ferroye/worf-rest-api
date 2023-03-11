package com.worf.worf;

import com.worf.worf.service.domain.Game;
import com.worf.worf.service.domain.role.Player;
import com.worf.worf.service.wolf.GameManagerService;
import com.worf.worf.service.wolf.factory.StageFactoryChain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorfApplicationTests {

	GameManagerService gameManagerService;
	StageFactoryChain roleFactoryChain;
	@BeforeEach
	void init(){

		gameManagerService = new GameManagerService();

	}

	@Test
	void contextLoads() {
		Game game = new Game();
		for(Player player : game.getPlayers()){
			roleFactoryChain.createStage(player);
		}

//		Role role = new SeerFactory();
//		game.setRoles();
//		gameManagerService.createGame();
	}

}
