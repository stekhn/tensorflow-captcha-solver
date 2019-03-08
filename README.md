# Tensorflow Captcha Solver
Solve image based captchas using [Tensorflow](https://www.tensorflow.org/) neural networks. This demo was developed for the [DAHO.AM Conference](https://daho.am/) in Munich, 2017.

**This repository is unmaintained and the code might not work as expected.** If you are looking for another Tensorflow-based solution, head over to: https://github.com/PatrickLib/captcha_recognize. 

## Getting started

Clone the repository:

```
$ git clone https://github.com/KarimJedda/dahoam2017.git
```

This guide was written for Mac users, but users might still find it useful. 

### Set up Python virtualenv

Create a new virtual environment:

```
$ virtualenv dahoam
```

Activate the virtual environment:

```
$ source dahoam/bin/activate
```

Check if the Python virtual environment is set up correctly:

```
$ which python
/Users/your-username/Development/dahoam2017/env/bin/python
```

Install dependencies:

```
$ pip install -r requirements.txt
```

**Troubleshooting:** Tensorflow could not be found:

```
Could not find a version that satisfies the requirement tensorflow==1.1.0 (from -r requirements.txt (line 51)) (from versions: )
No matching distribution found for tensorflow==1.1.0 (from -r requirements.txt (line 51))
```

If you encounter this error, try installing Tensorflow from the binary: 

```
$ python -m pip install --upgrade https://storage.googleapis.com/tensorflow/mac/cpu/tensorflow-1.1.0-py2-none-any.whl
```

*Linux or Windows users need to find another download link...*

### Generate captchas

Go to captchas folder:

```
$ cd captchas
``` 

Download [SimpleCaptcha](http://simplecaptcha.sourceforge.net) to the folder:

```
$ curl -O https://vorboss.dl.sourceforge.net/project/simplecaptcha/simplecaptcha-1.2-jdk1.5.jar
```

Extract SimpleCaptcha:

```
$ jar xf simplecaptcha-1.2-jdk1.5.jar
```

Run SimpleCaptcha:

```
$ javac Main.java && java Main
```

### Train the neural network

Once you've generated the test data, go to the solver folder:

```
$ cd solver
```

Create the tensorflow records:

```
$ python captcha_records.py 
```

Train the network (Note, that the training runs until you stop it):

```
$ python captcha_train.py 
```

Evaluate the performance of the network:

```
$ python captcha_eval.py
```

Try to solve some captchas:

```
$ python captcha_predict.py
```

Everything working? Great! Go solve some captchas (on your own machine for developing purposes, 'f course).

### Further info
If you want to see how a neural network is working, check out [Tenserflow Graph Viz](https://www.tensorflow.org/get_started/graph_viz).
