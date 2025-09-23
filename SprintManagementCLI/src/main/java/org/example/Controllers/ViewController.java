package org.example.Controllers;

import org.example.Util.DummyData;
import org.example.Util.InputHandler;

public interface ViewController {
    void onAppear();
    ViewController nextViewController();
}
