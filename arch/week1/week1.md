Team Members: Alex, Chris, Ross, Simon

## Week 1

In week 1, we completed CIRC-01 from Boxall. We successfully wired our board and LED, programmed, and ran our sketch. Here's our source code:

```
int ledPin = 13;
int blinkTime = 500;

void setup() {
  // put your setup code here, to run once:
  pinMode(ledPin, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(ledPin, HIGH);
  delay(blinkTime);
  digitalWrite(ledPin, LOW);
  delay(blinkTime);
}
```

Our LED blinked every .5 second.

## Project Proposal

Arduino Project - Weather Pod
Team: Alex, Ross, Simon, Chris

Week 1:
Boxall CIRC-01

Week 2:
Boxall CIRC-02

Week 3:
Boxall CIRC-07

Week 4:
Boxall CIRC-10

Week 5:
Weather pod basic tempature logging

Week 6:
Weather pod pressure and altometer logging

Week 7:
Weather pod remote data logging

Week 8:
Weather pod remote website protype

Week 9:
Weather pod remote website work

Week 10:
Wrap-up and demo

Initial Parts List:
Arduino Uno (or Mega), Ethernet Shield, Baromoter/Temp sensor, Battery Pack<Paste>
