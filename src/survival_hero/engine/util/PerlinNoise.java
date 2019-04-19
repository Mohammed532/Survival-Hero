package survival_hero.engine.util;

import java.util.concurrent.ThreadLocalRandom;

public class PerlinNoise {
	
	int width, height; //Optimized for 256*256
	int size = width * height; 
	float[] noiseSeed;
	float[] perlinNoise;
	int octaves;
	float scale;
	
	public PerlinNoise(int width, int height, int octaves) {
		this.width = width;
		this.height = height;
		this.octaves = octaves;
		
		generate();
		
	}
	
	private void generate() {
		size = width * height;
		
		noiseSeed = createRandomNoise();
		perlinNoise = new float[size];
//		System.out.println(size);
		
		for(int i = 0; i < size; i++) {
			float fNoise = 0.0f;
			scale = 1.0f;
			float scaleAcc = 0.0f;
			
			for(int o = 0; o < octaves; o++) {
				int pitch = (int) (size / Math.pow(2, o));
				int sample1 = (i / pitch) * pitch;
				int sample2 = (sample1 + pitch) % size;
				
				float blend = (float)(i - sample1) / (float) pitch;
				float sample = (1.0f - blend) * noiseSeed[sample1] + blend * noiseSeed[sample2];
				fNoise += sample * scale;
				scaleAcc += scale;
				scale = scale / 2.0f;
			}
			
			perlinNoise[i] = fNoise / scaleAcc;
			
		}
	}
	
	public float[] createRandomNoise() {
		size = width * height;
		
		float[] rNoise = new float[size];
		
		for(int i = 0; i < rNoise.length; i++) {
			rNoise[i]  = ThreadLocalRandom.current().nextFloat();
		}
		
		return rNoise;
	}
	
	public float getValue(int xOff) {
		float val = perlinNoise[xOff];
		return val;
	}
	
	public float[] getPerlinNoise() {
		return perlinNoise;
	}

}
