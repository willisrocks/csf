Team Members: Alex, Chris, Ross, Simon

## Project Proposal

Arduino Project - Weather Pod
Team: Alex, Ross, Simon, Chris

Week 1:
Boxall CIRC-01

Week 2:
Boxall CIRC-02

Week 3:
Boxall CIRC-07 and Ethernet shield testing

Week 4:
Boxall CIRC-10 and weather pod basic tempature logging

Week 5:
Weather pod data storage and transfer

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
Arduino Uno (or Mega), Ethernet Shield, Baromoter/Temp sensor, Battery Pack

## Week 4

We finished CIRC-10 and hooked up our Ethernet shield. We were able to get an IP address, and we were able to ping our arduino over the network. On Thursday, we hooked up our temp/pressure sensor, and verified that we could get data and output it to the serial monitor. We used this example program: https://github.com/adafruit/Adafruit_MPL3115A2_Library/blob/master/examples/testmpl3115a2/testmpl3115a2.ino

## Week 3

In week 3, we completed CIRC-07 from Boxall. We successfully wired our pushbuttons to controla LED bulb. We played with different ways to control the LED using our buttons, and we expiremented with counting the number of times we pressed the buttons.

## Week 2

In week 2, we completed CIRC-02 from Boxall. Additionaly, we successfully wired 8 LEDs and wrote a loop to cycle the LEDS in various patterns. Since we used red LEDs, it kind of looked like Kit from Knight Rider.

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
