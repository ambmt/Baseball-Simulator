package com.ambmt.simulator.simulation;
import java.util.Random;

public class TempSim {
    private Boolean abComplete;
    /*
    What returns mean :
    0 = "Ball"
    1 = "Strike"
    2 = "Foul"
    3 = "Ball in play"
    */


    // This calculates the pitch outcome - if the pitcher gets a margin, the pitch is redone if the outcome is unfavorable for the pitcher (ball or ball in play)
    // Done using the article https://www.baseball-fever.com/forum/general-baseball/statistics-analysis-sabermetrics/8142-pitch-outcome-distribution-over-25-years
    // Returns an integer depending on the result
    // After pitch 13, a foul is returned to prevent the outcome from being too long
    // Edge is calculated through OPS+ numbers
    public Integer calculatePitchOutcome(int pitch, boolean redoPitch, String edgePos, double margin, int redoPitchLoops, Random random) {
        int rand = random.nextInt(100) + 1;
        if (pitch == 1) {
            if (rand >= 1 && rand <= 43) {
                return marginPitcher(pitch, edgePos, margin, redoPitchLoops, random);
                // If in favour of the batter ,the pitch is redone on a non-favorable outcome
            } else if (rand >= 44 && rand <= 72) {
                // Called strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 73 && rand <= 82) {
                // Foul
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 83 && rand <= 88) {
                //Swinging strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else {
                // Ball in play
                if (edgePos.equals("Pitcher")) {
                    rand = random.nextInt(100) + 1;
                    if (rand >= 1 && rand <= Math.round(margin)) {// Do over
                        redoPitchLoops++;
                        return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                    } else {
                        return 3;
                    }
                } else {
                    return 3;
                }
            }
        } else if (pitch == 2) {
            if (rand >= 1 && rand <= 40) {
                // Ball
                return marginPitcher(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 41 && rand <= 56) {
                // Called strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 57 && rand <= 72) {
                // Foul
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 73 && rand <= 81) {
                // Swinging strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else {
                // Ball in play
                if (edgePos.equals("Pitcher")) {
                    rand = random.nextInt(100) + 1;
                    if (rand >= 1 && rand <= Math.round(margin)) {
                        redoPitchLoops++;
                        return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                    } else {
                        return 3;
                    }
                } else {
                    return 3;
                }
            }
        } else if (pitch == 3) {
            if (rand >= 1 && rand <= 39) {
                // Ball
                return marginPitcher(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 40 && rand <= 52) {
                // Called strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 53 && rand <= 70) {
                // Foul
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 71 && rand <= 80) {
                // Swinging strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else {
                // Ball in play
                if (edgePos.equals("Pitcher")) {
                    rand = random.nextInt(100) + 1;
                    if (rand >= 1 && rand <= Math.round(margin)) {
                        redoPitchLoops++;
                        return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                    } else {
                        return 3;
                    }
                } else {
                    return 3;
                }
            }
        } else if (pitch == 4) {
            if (rand >= 1 && rand <= 35) {
                // Ball
                return marginPitcher(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 36 && rand <= 47) {
                // Ball
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 48 && rand <= 68) {
                // Foul
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 69 && rand <= 80) {
                // Swinging strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else {
                // Ball in play
                if (edgePos.equals("Pitcher")) {
                    rand = random.nextInt(100) + 1;
                    if (rand >= 1 && rand <= Math.round(margin)) {
                        redoPitchLoops++;
                        return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                    } else {
                        return 3;
                    }
                } else {
                    return 3;
                }
            }
        } else if (pitch == 5) {
            if (rand >= 1 && rand <= 31) {
                // ball
                return marginPitcher(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 32 && rand <= 40) {
                // Called strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 41 && rand <= 61) {
                // Foul
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 62 && rand <= 73) {
                // Swinging strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else {
                // Ball in play
                if (edgePos.equals("Pitcher")) {
                    rand = random.nextInt(100) + 1;
                    if (rand >= 1 && rand <= Math.round(margin)) {
                        redoPitchLoops++;
                        return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                    } else {
                        return 3;
                    }
                } else {
                    return 3;
                }
            }
        } else if (pitch == 6) {
            if (rand >= 1 && rand <= 26) {
                // Ball
                return marginPitcher(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 27 && rand <= 30) {
                // Called strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 31 && rand <= 53) {
                // Foul
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 54 && rand <= 65) {
                // Swinging strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else {
                // Ball in play
                if (edgePos.equals("Pitcher")) {
                    rand = random.nextInt(100) + 1;
                    if (rand >= 1 && rand <= Math.round(margin)) {
                        redoPitchLoops++;
                        return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                    } else {
                        return 3;
                    }
                } else {
                    return 3;
                }
            }
        } else if (pitch == 7) {
            if (rand >= 1 && rand <= 25) {
                // Ball
                return marginPitcher(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 26 && rand <= 29) {
                // Called strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 30 && rand <= 57) {
                // Foul
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 58 && rand <= 69) {
                // Swinging strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else {
                // Ball in play
                if (edgePos.equals("Pitcher")) {
                    rand = random.nextInt(100) + 1;
                    if (rand >= 1 && rand <= Math.round(margin)) {
                        redoPitchLoops++;
                        return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                    } else {
                        return 3;
                    }
                } else {
                    return 3;
                }
            }
        } else if (pitch == 8) {
            if (rand >= 1 && rand <= 24) {
                // Ball
                return marginPitcher(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 25 && rand <= 28) {
                // Called strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 29 && rand <= 57) {
                // Foul
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 58 && rand <= 68) {
                // Foul
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else {
                // Ball in play
                if (edgePos.equals("Pitcher")) {
                    rand = random.nextInt(100) + 1;
                    if (rand >= 1 && rand <= Math.round(margin)) {
                        redoPitchLoops++;
                        return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                    } else {
                        return 3;
                    }
                } else {
                    return 3;
                }
            }
        } else if (pitch == 9) {
            if (rand >= 1 && rand <= 23) {
                // Ball
                return marginPitcher(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 24 && rand <= 26) {
                // Called strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 27 && rand <= 57) {
                // Foul
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
                // Swinging strike
            } else if (rand >= 58 && rand <= 68) {
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else {
                // Ball in play
                if (edgePos.equals("Pitcher")) {
                    rand = random.nextInt(100) + 1;
                    if (rand >= 1 && rand <= Math.round(margin)) {
                        redoPitchLoops++;
                        return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                    } else {
                        return 3;
                    }
                } else {
                    return 3;
                }
            }
        } else if (pitch == 10) {
            // Ball
            if (rand >= 1 && rand <= 22) {
                return marginPitcher(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 23 && rand <= 25) {
                // Called strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 26 && rand <= 57) {
                // Foul
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 58 && rand <= 68) {
                // Swinging strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else {
                // Ball in play
                if (edgePos.equals("Pitcher")) {
                    rand = random.nextInt(100) + 1;
                    if (rand >= 1 && rand <= Math.round(margin)) {
                        redoPitchLoops++;
                        return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                    } else {
                        return 3;
                    }
                } else {
                    return 3;
                }
            }
        } else if (pitch == 11) {
            if (rand >= 1 && rand <= 22) {
                // Ball - pitcher edge
                return marginPitcher(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 23 && rand <= 25) {
                // Called strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 26 && rand <= 57) {
                // Foul
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 58 && rand <= 68) {
                //Swinging strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            } else {
                // A ball is in play
                if (edgePos.equals("Pitcher")) {
                    rand = random.nextInt(100) + 1;
                    if (rand >= 1 && rand <= Math.round(margin)) {
                        redoPitchLoops++;
                        return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                    } else {
                        return 3;
                    }
                } else {
                    return 3;
                }
            }
        } else if (pitch == 12) {
            // Ball
            if (rand >= 1 && rand <= 28) {
                return marginPitcher(pitch, edgePos, margin, redoPitchLoops, random);
            } else if (rand >= 29 && rand <= 40) {
                // Called strike
                return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
            }
                // At this moment the origin code was wrong, there was an && instead of an ||

                else if(rand >= 41 && rand <= 58) { // Assuming the intended condition was an OR
                    // Swinging strike
                    if ("Batter".equals(edgePos)) {
                        rand = random.nextInt(100) + 1;
                        if (1 <= rand && rand <= Math.round(margin)) {
                            redoPitchLoops += 1;
                            return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
                        } else {
                            return 1;
                        }
                    } else {
                        return 1;
                    }
                } else {
                    // This is a ball in play
                    return marginBatter(pitch, edgePos, margin, redoPitchLoops, random);
                }

            }
        return -1;
        }

    private Integer marginBatter(int pitch, String edgePos, double margin, int redoPitchLoops, Random random) {
        int rand;
        if (edgePos.equals("Batter")) {
            rand = random.nextInt(100) + 1;
            if (rand >= 1 && rand <= Math.round(margin)) {
                redoPitchLoops++;
                return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }

    private Integer marginPitcher(int pitch, String edgePos, double margin, int redoPitchLoops, Random random) {
        int rand;
        if (edgePos.equals("Pitcher")) {
            // Ball
            rand = random.nextInt(100) + 1;
            if (rand >= 1 && rand <= Math.round(margin)) {
                redoPitchLoops++;
                return calculatePitchOutcome(pitch, true, edgePos, margin, redoPitchLoops, random);
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

}


