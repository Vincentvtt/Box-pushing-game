Wire POT to PK8?
Both jumpers should be on above the potentiometer. These connect the ends of the POT to vcc and gnd.

I ended up setting up a timer that triggered every 50msec and during the interrupt I would

1. Configure the ADC registers (with the code we were given), 
ADMUX = (3 << REFS0) | (0 << ADLAR) | (0 << MUX0);
ldi temp, (3 << REFS0) | (0 << ADLAR) | (0 << MUX0);
sts ADMUX, temp

ADCSRB = (1 << MUX5);
ldi temp, (1 << MUX5);
sts ADCSRB, temp

ADCSRA = (1 << ADEN) | (1 << ADSC) | (1 << ADIE) | (5 << ADPS0);
ldi temp, (1 << ADEN) | (1 << ADSC) | (1 << ADIE) | (5 << ADPS0);
sts ADCSRA, temp

2. Take the ADC reading
lds temp1, ADCL  
lds temp2, ADCH

3. Compare those two registers with low(0x3ff)/high(0xff) (twisted right) or 0 (twisted left)

ldi temp3, low(0x3ff) ? 
ldi temp4, high(0x3ff) ?

cp temp1, temp3 ?
cpc temp2, temp4 ?

breq Maximum_Clockwise:

ldi temp3, low(0) ? 
ldi temp4, high(0) ?

cp temp1, temp3 ?
cpc temp2, temp4 ?

breq Maximum_Anticlockwise:

4. clear ADC registers to stop it reading.
clr temp1?
clr temp2?

