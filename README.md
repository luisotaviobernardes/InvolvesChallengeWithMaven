# Involves Challenge

## Cloning

```
git clone https://github.com/luisotaviobernardes/InvolvesChallengeWithMaven.git
```

## Building, Running and Testing

ps: when building, the script will try to delete, copy and do some manipulation of files, so make sure you have the right permissions to do so.
ps²: in case there is some trouble with the csv path, the same is set at com.luis.otavio.utils.Bootstrap, currently was tested on windows(W10) and unix(Ubuntu 14) and it worked fine.

### Unix

ps: Maven can be used to run on unix instances also.

```
chmod +x build_unix.sh
chmod +x run_unix.sh
```

Build:

```
./build_unix.sh
```

Run:
```
./run_unix.sh
```

Testing:
```
mvn test
```

### Windows

Maven integration was added so windows could be used to compile
