//written by @joseCao5
//
//30_03_14
//Part of CaosPercLib01
//Pad of trippy ambience
CaosPad2 {
			*ar {|att = 0.5, rel = 1, note = 220, fmax = 1, fm = 0.001, harm = 1, rmix = 0.5, rroom = 0.5, rfilt = 0.1,
							gate = 0, amp1 = 0.5, amp2 = 0.5 |
					var sig1,sig2,pad,nota,env;
						nota=note.midicps;
						sig1=SinOsc.ar(SinOsc.kr(fm,0,nota,nota+fmax),0,amp1);
						sig2=Blip.ar(Blip.kr(fm,harm/2,nota,nota+fmax),harm,amp2);
						env=EnvGen.kr(Env.perc(att+0.5,rel+1),gate,doneAction:2);
					    pad=FreeVerb2.ar(sig1*env,sig2*env,rmix,rroom,rfilt);
					   ^Pan2.ar(pad,[1, -0.976])
			}
}
