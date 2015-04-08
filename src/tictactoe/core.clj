(ns tictactoe.core)

; Require Clojure numeric-tower library
(require '[clojure.math.numeric-tower :as math])

; Imports
(import 'javax.swing.JButton)
(import 'javax.swing.JPanel)
(import 'javax.swing.JFrame)
(import 'java.awt.event.ActionListener)
(import 'java.awt.GridLayout)
(import 'java.awt.Font)
(import 'javax.swing.JOptionPane)

(defn runGame []
	; Define some variables
	(def playerScore 0)
	(def computerScore 0)
	(def matrix '(0 0 0 0 0 0 0 0 0))

	; Define the frame
	(def frame (JFrame. "Tic Tac Toe"))
	(.setDefaultCloseOperation frame JFrame/EXIT_ON_CLOSE)
	(.setSize frame 400 400)
	(.setLocationRelativeTo frame nil)
	(.setResizable frame false)

	; Container panel
	(def panel (JPanel.))
	(.setLayout panel (GridLayout. 3 3))
	(.setContentPane frame panel)

	(def btn_x1y1 (JButton. " "))
	(def btn_x1y2 (JButton. " "))
	(def btn_x1y3 (JButton. " "))

	(def btn_x2y1 (JButton. " "))
	(def btn_x2y2 (JButton. " "))
	(def btn_x2y3 (JButton. " "))

	(def btn_x3y1 (JButton. " "))
	(def btn_x3y2 (JButton. " "))
	(def btn_x3y3 (JButton. " "))

	(.setFont btn_x1y1 (Font. "Arial", 1, 50))
	(.setFont btn_x1y2 (Font. "Arial", 1, 50))
	(.setFont btn_x1y3 (Font. "Arial", 1, 50))

	(.setFont btn_x2y1 (Font. "Arial", 1, 50))
	(.setFont btn_x2y2 (Font. "Arial", 1, 50))
	(.setFont btn_x2y3 (Font. "Arial", 1, 50))

	(.setFont btn_x3y1 (Font. "Arial", 1, 50))
	(.setFont btn_x3y2 (Font. "Arial", 1, 50))
	(.setFont btn_x3y3 (Font. "Arial", 1, 50))

	(.add panel btn_x1y1)
	(.add panel btn_x1y2)
	(.add panel btn_x1y3)

	(.add panel btn_x2y1)
	(.add panel btn_x2y2)
	(.add panel btn_x2y3)

	(.add panel btn_x3y1)
	(.add panel btn_x3y2)
	(.add panel btn_x3y3)

	; Define action listener for the button click
	(def buttonAction
        (proxy [ActionListener] []
        (actionPerformed [event]
        	(.setText (.getSource event) "X")
        	(.setEnabled (.getSource event) false)
        	; Perform computer actions now
        	; Generate random number
        	(def tile (int (math/floor (rand 8))))
        	; Time for the computer to make a move
    )))

	; Event listeners
	(.addActionListener btn_x1y1 buttonAction)
	(.addActionListener btn_x1y2 buttonAction)
	(.addActionListener btn_x1y3 buttonAction)

	(.addActionListener btn_x2y1 buttonAction)
	(.addActionListener btn_x2y2 buttonAction)
	(.addActionListener btn_x2y3 buttonAction)

	(.addActionListener btn_x3y1 buttonAction)
	(.addActionListener btn_x3y2 buttonAction)
	(.addActionListener btn_x3y3 buttonAction)

	; Show the frame
	(.setVisible frame true)

	; Show the GUI
	(JOptionPane/showMessageDialog nil "Welcome to Tic Tac Toe! Press OK to begin.", "Tic Tac Toe" JOptionPane/INFORMATION_MESSAGE)
)

(defn -main [& args] (
	runGame
))
