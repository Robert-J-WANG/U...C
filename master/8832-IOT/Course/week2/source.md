source

1. Mosquitto server authentication methods

     https://mosquitto.org/documentation/authentication-methods/ 

2. Installing and Upgrading Node-RED on a Raspberry Pi

     https://nodered.org/docs/getting-started/raspberrypi

3. Some notes on setting up MQTT over TLS

    https://forums.raspberrypi.com/viewtopic.php?t=287326

4. Steve's guide - Mosquitto MQTT Broker SSL Configuration Using Own Certificates

     http://www.steves-internet-guide.com/mosquitto-tls/

5. linux code in the class

     ```bash
     1  ls'
    2  quit
    3  quit()
    4  exit
    5  ifconfig
    6  sudo apt-get update
    7  logout
    8  sudo apt-get install mosquitto
    9  mosquitto
   10  sudo apt-get install mosquitto-clients
   11  mosquitto_pub -h broker.hivemq.com -p 1883 -t /gprado/test/ -m hola
   12  mosquitto_pub -h broker.hivemq.com -p 1883 -t "/gprado/test/" -m "hola professor"
   13  mosquitto_pub -h broker.hivemq.com -p 1883 -t /gprado/test/ -m "hola professor"
   14  mosquitto_pub -h broker.hivemq.com -p 1883 -t /gprado/test -m "hola professor"
   15  mosquitto_pub -h broker.hivemq.com -p 1883 -t /gprado/test -m "hello from Yang & Matthew"
   16  sudo apt-get install nodered
   17  ifconfig
   18  bash <(curl -sL https://raw.githubusercontent.com/node-red/linux-installers/master/deb/update-nodejs-and-nodered)
   19  sudo shutdown now
   20  mosquitto_pub -h broker.hivemq.com -p 1883 -t "/gprado/test" -m hi"
   21  quit
   22  exit
   23  mosquitto_pub -h broker.hivemq.com -p 1883 -t "/gprado/test" -m "hi"
   24  mosquitto_sub -h broker.hivemq.com -p 1883 -t "/gprado/test"
   25  ls
   26  ?
   27  1+1
   28  state
   29  sudo ifconfig 
   30  mosquitto_sub -h 192.168.252.37 -t test
   31  echo $?
   32  cd /etc/mosquitto
   33  ls
   34  sudo nano mosquitto.conf 
   35  sudo apt-get update
   36  mosquitto
   37  mosquitto_pub
   38  mosquitto_sub
   39  sudo apt-get mosquitto
   40  sudo apt-get install mosquitto
   41  mosquitto_sub -h comitup@comitup-593.local -t test
   42  mosquitto_sub -h comitup@comitup-593 -t test
   43  mosquitto_sub -h 192.168.252.37 -t test
   44  mosquitto_sub -h comitup@comitup-593.local -t test
   45  echo $?
   46  cd /etc/mosquitto
   47  ls
   48  sudo nano mosquitto.conf
   49  clear
   50  mosquitto
   51  mosquitto_pub
   52  clear
   53  mosquitto_sub
   54  sudo ps -A
   55  sudo ps -A|grep mosquitto
   56  sudo ifconfig 
   57  mosquitto_sub -h 192.168.252.37 -t test
   58  echo mosquitto_sub -h 192.168.252.37 -t test
   59  mosquitto_sub -h 192.168.252.37 -t test
   60  echo $?
   61  cd /etc/mosquitto/
   62  ls
   63  sudo nano mosquitto.conf 
   64  sudo reboot 
   65  sudo ps -A|egrep mosquitto
   66  mosquitto_sub -h comitup@comitup-593.local -t test
   67  mosquitto_sub -h 192.168.252.37 -t test
   68  mosquitto_pub -t test -m "hola senor"
   69  sudo ps -A|egrep mosquitto
   70  mosquitto_sub -h 192.168.252.37 -t test
   71  cd /etc/mosquitto/
   72  nano mosquitto.conf 
   73  cd ~
   74  mosquitto_sub -h 192.168.252.37 -t test
   75  clear
   76  cd /etc/mosquitto/
   77  nano mosquitto.conf 
   78  sudo nano mosquitto.conf 
   79  sudo reboot
   80  mosquitto_sub -h 192.168.252.37 -t test
   81  mosquitto_pub -t test2 -m "123"
   82  sudo ps -A|grep mosquitto
   83  mosquitto_pub -t test -m "hola mundo"
   84  nodered
   85  sudo nodered
   86  sudo apt-get install nodered
   87  bash <(curl -sL https://raw.githubusercontent.com/node-red/linux-installers/master/deb/update-nodejs-and-nodered)
   88  bash <(curl -sL https://raw.githubusercontent.com/node-red/linux-installers/master/deb/update-nodejs-and-nodered) --node20
   89  clear
   90  bash <(curl -sL https://raw.githubusercontent.com/node-red/linux-installers/master/deb/update-nodejs-and-nodered)
   91  bash <(curl -sL https://raw.githubusercontent.com/node-red/linux-installers/master/deb/update-nodejs-and-nodered) --node20
   92  df
   93  sudo ps -A|grep node
   94  nodered
   95  node-red
   96  vmstat -s
   97  mosquitto_pub -t test -m "5"
   98  mosquitto_pub -t test -m "7"
   99  vmstat -s
    100  vmstat -s|more
    101  mosquitto_sub -h 192.168.252.37 -t test2
    102  sudo ps -A|grep node
    103  sudo ps -A|grep mosqu
    104  mosquitto_sub -h 192.168.252.37 -t test2
    105  node-red
    106  echo $?
    107  cd /etc/mosquitto/
    108  ls
    109  sudo mosquitto_passwd --help
    110  sudo mosquitto_passwd -c pwfile gprado
    111  ls
    112  cat pwfile
    113  sudo reboot
    114  sudo nano /etc/mosquitto/mosquitto.conf 
    115  sudo reboot
    116  sudo systemctl status mosquitto.service 
    117  clear
    118  mosquitto_sub -h 192.168.252.37 -t test
    119  mosquitto_sub -h 192.168.252.37 -t test -u gprado -P m3x1c0
    120  history
    121  history > myhistory.txt

