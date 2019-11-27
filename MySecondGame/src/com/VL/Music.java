package com.VL;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Music {
	static URL bgUrl_1;//音乐文件地址
	static URL bgUrl_2;
	static URL bgUrl_3;
	static URL bgUrl_4;
	static URL bgUrl_5;
	static URL bgUrl_6;
	static URL bgUrl_7;
	static AudioClip bg1;//播放音乐文件的对象
	static AudioClip bg2;
	static AudioClip bg3;
	static AudioClip bg4;
	static AudioClip bg5;
	static AudioClip bg6;
	static AudioClip bg7;
	static{
		try {
			bgUrl_1 = new File("music/start1.wav").toURL();
			bgUrl_2 = new File("music/running.wav").toURL();
			bgUrl_3 = new File("music/levelup.wav").toURL();
			bgUrl_4 = new File("music/cut1.wav").toURL();
			bgUrl_5 = new File("music/yun.wav").toURL();
			bgUrl_6 = new File("music/buff2.wav").toURL();
			bgUrl_7 = new File("music/end.wav").toURL();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		bg1 = Applet.newAudioClip(bgUrl_1);
		bg2 = Applet.newAudioClip(bgUrl_2);
		bg3 = Applet.newAudioClip(bgUrl_3);
		bg4 = Applet.newAudioClip(bgUrl_4);
		bg5 = Applet.newAudioClip(bgUrl_5);
		bg6 = Applet.newAudioClip(bgUrl_6);
		bg7 = Applet.newAudioClip(bgUrl_7);	
	}
}