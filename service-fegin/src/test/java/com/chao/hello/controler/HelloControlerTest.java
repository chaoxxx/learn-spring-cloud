package com.chao.hello.controler;

import org.junit.Test;

public class HelloControlerTest {

	@Test
	public void sendGet() throws InterruptedException {

		for (int i = 0; i < 20; i++) {

			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						
					}
				}
			}).join();
			;
		}
		;

	}
}
