package com.ambmt.simulator.simulation;
import java.util.Random;

public class TempSim {

        public void TempSim() {
            Random random = new Random();
            calculatePitchOutcome(1, false, "Pitcher", 0, 0, random);
        }

        public static String calculatePitchOutcome(int pitch, boolean redoPitch, String edgePos, double margin, int redoPitchLoops, Random random) {
            int rand = random.nextInt(100) + 1;
            if (pitch == 1) {
                if (rand >= 1 && rand <= 43) {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball";
                        }
                    } else {
                        return "Ball";
                    }
                } else if (rand >= 44 && rand <= 72) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else if (rand >= 73 && rand <= 82) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Foul";
                        }
                    } else {
                        return "Foul";
                    }
                } else if (rand >= 83 && rand <= 88) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball_in_play";
                        }
                    } else {
                        return "Ball_in_play";
                    }
                }
            } else if (pitch == 2) {
                if (rand >= 1 && rand <= 40) {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball";
                        }
                    } else {
                        return "Ball";
                    }
                } else if (rand >= 41 && rand <= 56) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else if (rand >= 57 && rand <= 72) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Foul";
                        }
                    } else {
                        return "Foul";
                    }
                } else if (rand >= 73 && rand <= 81) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball_in_play";
                        }
                    } else {
                        return "Ball_in_play";
                    }
                }
            } else if (pitch == 3) {
                if (rand >= 1 && rand <= 39) {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball";
                        }
                    } else {
                        return "Ball";
                    }
                } else if (rand >= 40 && rand <= 52) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else if (rand >= 53 && rand <= 70) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Foul";
                        }
                    } else {
                        return "Foul";
                    }
                } else if (rand >= 71 && rand <= 80) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball_in_play";
                        }
                    } else {
                        return "Ball_in_play";
                    }
                }
            } else if (pitch == 4) {
                if (rand >= 1 && rand <= 35) {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball";
                        }
                    } else {
                        return "Ball";
                    }
                } else if (rand >= 36 && rand <= 47) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else if (rand >= 48 && rand <= 68) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Foul";
                        }
                    } else {
                        return "Foul";
                    }
                } else if (rand >= 69 && rand <= 80) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball_in_play";
                        }
                    } else {
                        return "Ball_in_play";
                    }
                }
            } else if (pitch == 5) {
                if (rand >= 1 && rand <= 31) {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball";
                        }
                    } else {
                        return "Ball";
                    }
                } else if (rand >= 32 && rand <= 40) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else if (rand >= 41 && rand <= 61) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Foul";
                        }
                    } else {
                        return "Foul";
                    }
                } else if (rand >= 62 && rand <= 73) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball_in_play";
                        }
                    } else {
                        return "Ball_in_play";
                    }
                }
            } else if (pitch == 6) {
                if (rand >= 1 && rand <= 26) {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball";
                        }
                    } else {
                        return "Ball";
                    }
                } else if (rand >= 27 && rand <= 30) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else if (rand >= 31 && rand <= 53) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Foul";
                        }
                    } else {
                        return "Foul";
                    }
                } else if (rand >= 54 && rand <= 65) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball_in_play";
                        }
                    } else {
                        return "Ball_in_play";
                    }
                }
            } else if (pitch == 7) {
                if (rand >= 1 && rand <= 25) {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball";
                        }
                    } else {
                        return "Ball";
                    }
                } else if (rand >= 26 && rand <= 29) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else if (rand >= 30 && rand <= 57) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Foul";
                        }
                    } else {
                        return "Foul";
                    }
                } else if (rand >= 58 && rand <= 69) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball_in_play";
                        }
                    } else {
                        return "Ball_in_play";
                    }
                }
            } else if (pitch == 8) {
                if (rand >= 1 && rand <= 24) {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball";
                        }
                    } else {
                        return "Ball";
                    }
                } else if (rand >= 25 && rand <= 28) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else if (rand >= 29 && rand <= 57) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Foul";
                        }
                    } else {
                        return "Foul";
                    }
                } else if (rand >= 58 && rand <= 68) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball_in_play";
                        }
                    } else {
                        return "Ball_in_play";
                    }
                }
            } else if (pitch == 9) {
                if (rand >= 1 && rand <= 23) {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball";
                        }
                    } else {
                        return "Ball";
                    }
                } else if (rand >= 24 && rand <= 26) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else if (rand >= 27 && rand <= 57) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Foul";
                        }
                    } else {
                        return "Foul";
                    }
                } else if (rand >= 58 && rand <= 68) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball_in_play";
                        }
                    } else {
                        return "Ball_in_play";
                    }
                }
            } else if (pitch == 10) {
                if (rand >= 1 && rand <= 22) {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball";
                        }
                    } else {
                        return "Ball";
                    }
                } else if (rand >= 23 && rand <= 25) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else if (rand >= 26 && rand <= 57) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Foul";
                        }
                    } else {
                        return "Foul";
                    }
                } else if (rand >= 58 && rand <= 68) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball_in_play";
                        }
                    } else {
                        return "Ball_in_play";
                    }
                }
            } else if (pitch == 11) {
                if (rand >= 1 && rand <= 22) {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball";
                        }
                    } else {
                        return "Ball";
                    }
                } else if (rand >= 23 && rand <= 25) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else if (rand >= 26 && rand <= 57) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Foul";
                        }
                    } else {
                        return "Foul";
                    }
                } else if (rand >= 58 && rand <= 68) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball_in_play";
                        }
                    } else {
                        return "Ball_in_play";
                    }
                }
            } else if (pitch == 12) {
                if (rand >= 1 && rand <= 28) {
                    if (edgePos.equals("Pitcher")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Ball";
                        }
                    } else {
                        return "Ball";
                    }
                } else if (rand >= 29 && rand <= 40) {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Strike";
                        }
                    } else {
                        return "Strike";
                    }
                } else {
                    if (edgePos.equals("Batter")) {
                        rand = random.nextInt(100) + 1;
                        if (rand >= 1 && rand <= Math.round(margin)) {
                            redoPitchLoops++;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return "Foul";
                        }
                    } else {
                        return "Foul";
                    }
                }
            }
            return "";
        }
    }

/*
import java.util.Random;

// Assuming calculatePitchOutcome is defined elsewhere with the following signature:
// String calculatePitchOutcome(String pitch, boolean isRedo, String edgePos, double margin, int redoPitchLoops)

Random random = new Random();
int rand = random.nextInt(100) + 1; // random number between 1 and 100

if (1 <= rand && rand <= Math.round(margin)) {
    redoPitchLoops += 1;
    return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops);
} else {
    return "Foul";
}
// The rest of the code seems to be part of a larger context that is not provided.
// The following is an attempt to translate the given structure into Java, but it may not be complete.

// Assuming this is part of a method, we continue the translation
// else if (rand <= 41 && rand <= 58) { // This condition will never be true, it seems to be an error in the original code
if (rand <= 41 || rand <= 58) { // Assuming the intended condition was an OR
    if ("Batter".equals(edgePos)) {
        rand = random.nextInt(100) + 1;
        if (1 <= rand && rand <= Math.round(margin)) {
            redoPitchLoops += 1;
            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops);
        } else {
            return "Strike";
        }
    } else {
        return "Strike";
    }
} else {
    if ("Pitcher".equals(edgePos)) {
        rand = random.nextInt(100) + 1;
        if (1 <= rand && rand <= Math.round(margin)) {
            redoPitchLoops += 1;
            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops);
        } else {
            return "Ball_in_play";
        }
    } else {
        return "Ball_in_play";
    }
}



*/

