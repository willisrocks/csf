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
