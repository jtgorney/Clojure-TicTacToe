(ns tictactoe.core)

; Require Clojure numeric-tower library
(require '[clojure.math.numeric-tower :as math])
(require '[clojure.set :as set])

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
	(def playerX '#{})
	(def playerO '#{})

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
        	; Player's choice
        	(.setText (.getSource event) "O")
        	(.setEnabled (.getSource event) false)




        	; Determine which button was clicked and add to moves list.





        	; Perform computer actions now
        	; Generate random number
        	(def available (seq (set/intersection (set/union playerX playerO) playerX)))
        	(def totalSpots (- 8 (count available)))
        	(def tile (int (math/floor (rand totalSpots))))
        	; Redefine playerX with the new selection
        	(def playerX (conj playerX tile))
        	; Now just mark the right button with X
        	; Row 1
        	(if (= tile 0) (
        	(fn [] 
        		(.setText btn_x1y1 "X")
        		(.setEnabled btn_x1y1 false)
        	)))
        	(if (= tile 1) (
        	(fn [] 
        		(.setText btn_x1y2 "X")
        		(.setEnabled btn_x1y2 false)
        	)))
        	(if (= tile 2) (
        	(fn [] 
        		(.setText btn_x1y3 "X")
        		(.setEnabled btn_x1y3 false)
        	)))
        	; Row 2
        	(if (= tile 3) (
        	(fn [] 
        		(.setText btn_x2y1 "X")
        		(.setEnabled btn_x2y1 false)
        	)))
        	(if (= tile 4) (
        	(fn [] 
        		(.setText btn_x2y2 "X")
        		(.setEnabled btn_x2y2 false)
        	)))
        	(if (= tile 5) (
        	(fn [] 
        		(.setText btn_x2y3 "X")
        		(.setEnabled btn_x2y3 false)
        	)))
        	; Row 3
        	(if (= tile 6) (
        	(fn [] 
        		(.setText btn_x3y1 "X")
        		(.setEnabled btn_x3y1 false)
        	)))
        	(if (= tile 7) (
        	(fn [] 
        		(.setText btn_x3y2 "X")
        		(.setEnabled btn_x3y2 false)
        	)))
        	(if (= tile 8) (
        	(fn [] 
        		(.setText btn_x3y3 "X")
        		(.setEnabled btn_x3y3 false)
        	)))
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

; Main function/entry point for application
(defn -main [& args] (
	runGame
))
