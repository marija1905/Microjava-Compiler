package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CodeGenerator extends VisitorAdaptor {
	private int mainPC;
	private Obj addMeth = Tab.find("add");
	
	CodeGenerator(){
		Obj ordMeth = Tab.find("ord");
		ordMeth.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load_n);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		Obj chrMeth = Tab.find("chr");
		chrMeth.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load_n);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		Obj lenMeth = Tab.find("len");
		lenMeth.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load_n);
		Code.put(Code.arraylength);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		// add
		addMeth.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(2); // b1
		Code.put(3); // b2 -> this means add(a,b) x;
		
		Code.loadConst(1); // 1
		Code.put(Code.store_2); // -  |  i = 1
		Code.put(Code.load_n); // set | i = 1
		Code.loadConst(0); // set 0 | i = 1
		Code.put(Code.aload); // set[0] | i = 1
		Code.put(Code.load_2); // set[0] 1 
		// loop
		int pc0 = Code.pc;
		Code.putFalseJump(Code.ge, 0); // - | if(i > set[0]) == true we jump to add an elem
		int pc1 = Code.pc - 2;
		Code.put(Code.load_n); // set
		Code.put(Code.load_2); // set i
		Code.put(Code.aload); // set[i]
		Code.put(Code.load_1); // set[i] b
		Code.putFalseJump(Code.ne, 0); // - | if(set[i] == b) we don't add
		int pc2 = Code.pc - 2;
		Code.put(Code.load_n); // set
		Code.loadConst(0); // set 0
		Code.put(Code.aload); // set[0]
		Code.put(Code.load_2); // set[0] i
		Code.loadConst(1); // set[0] i 1
		Code.put(Code.add); // set[0] i+1
		Code.put(Code.store_2); // set[0] | i = i+1
		Code.put(Code.load_2); // set[0] (i+1)!
		
		//fixap --> we add elem
		Code.putJump(pc0);
		Code.fixup(pc1); // -
		Code.put(Code.load_n); // set
		Code.put(Code.load_2); // set i
		Code.put(Code.load_1); // set i b
		Code.put(Code.astore); // - | set[i] = b
		Code.put(Code.load_n); //set
		Code.loadConst(0); // set 0
		Code.put(Code.load_2); // set 0 i
		Code.put(Code.astore); // -
		
		Code.fixup(pc2);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		//TODO addAll(a, b) --> a is set, b is array
		Obj addAllMeth = Tab.find("addAll");
		addAllMeth.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(2); // b1
		Code.put(3); // b2 -> this means add(a,b) x;
		
		Code.loadConst(0); // 0
		Code.put(Code.store_2); // - | i = 0
		Code.put(Code.load_1); // b  | i = 0
		Code.put(Code.arraylength); // len | i = 0
		Code.put(Code.dup); // len len
		Code.put(Code.load_2); //len len 0 | i = 0
		
		// loop
		int pc3 = Code.pc;
		Code.putFalseJump(Code.gt, 0); // - | if(i > set[0]) == true we jump to add an elem
		int pc4 = Code.pc - 2;
		Code.put(Code.load_n); //len set
		Code.put(Code.load_1); // len set arr
		Code.put(Code.load_2); // len set arr i
		Code.put(Code.aload); // len set arr[i]
		
		Code.put(Code.call);
		Code.put2(addMeth.getAdr() - Code.pc + 1);
		
		Code.put(Code.dup); // len len
		Code.put(Code.load_2); // len len i
		Code.loadConst(1); // len len i 1
		Code.put(Code.add); // len len i+1
		Code.put(Code.store_2); // len len | i = i+1
		Code.put(Code.load_2); // len len (i+1)!
		
		//fixap --> we add elem
		Code.putJump(pc3);
		Code.fixup(pc4); // len
		Code.put(Code.pop);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		
	}
	
	public int getMainPc() {
		return this.mainPC;
	}
	
	@Override
	public void visit(MethodSignature_void methSign) {
		methSign.obj.setAdr(Code.pc);
		if(methSign.getI1().equals("main")) {
			this.mainPC = Code.pc;
		}
		
		Code.put(Code.enter);
		Code.put(methSign.obj.getLevel()); // (b1) enter b1, b2
		Code.put(methSign.obj.getLocalSymbols().size()); // (b2) enter b1, b2
	}
	
	@Override
	public void visit(MethodSignature_type methSign) {
		methSign.obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(methSign.obj.getLevel()); // (b1) enter b1, b2
		Code.put(methSign.obj.getLocalSymbols().size()); // (b2) enter b1, b2
	}
	
	@Override
	public void visit(MethodDecl methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	/* STATEMENTS */
	
	@Override
	public void visit(Statement_print stmtPrint) {
		if(stmtPrint.getNumConstSquare() instanceof NoNumConstSquare) {
			Code.loadConst(0);
		}
		if(stmtPrint.getExpr().struct.equals(Tab.charType)) {
			Code.put(Code.bprint);
		}
		else {
			if(stmtPrint.getExpr().struct.equals(Tab.find("set").getType())) {
				Code.put(Code.enter);
				Code.put(2);
				Code.put(3); // moje i 
				
				Code.put(Code.load_n); // set
				Code.loadConst(1); // set 1
				Code.put(Code.store_2); // set | i = 1
				Code.put(Code.dup); // set set
				Code.loadConst(0); // set set 0 | i = 1
				Code.put(Code.aload); //set set[0] | i = 1 
				Code.put(Code.load_2); //set set[0] 1
				
				// loop
				int pc0 = Code.pc;
				Code.putFalseJump(Code.ge, 0); // set | if(i > set[0]) == true we jump to add an elem
				int pc1 = Code.pc - 2;
				Code.put(Code.dup); // set set
				Code.put(Code.load_2); // set set i
				Code.put(Code.aload); // set set[i]
				Code.loadConst(1);// set set[i] 1
				Code.put(Code.print); // set
				Code.loadConst(' ');
				Code.loadConst(1);
				Code.put(Code.bprint);
				
				Code.put(Code.dup);
				Code.loadConst(0); // set set 0
				Code.put(Code.aload); // set set[0]
				Code.put(Code.load_2); //set set[0] i
				
				Code.loadConst(1); // set set[0] i 1
				Code.put(Code.add); //set set[0] i+1
				Code.put(Code.store_2); //set set[0] | i = i+1
				Code.put(Code.load_2); //set set[0] (i+1)!
				
				Code.putJump(pc0);
				Code.fixup(pc1); // set
				Code.put(Code.pop);
				Code.put(Code.exit);
			}
			else {
				Code.put(Code.print);
			}
		}
	}
	
	@Override
	public void visit(NumConstSquare_node numConst) {
		Code.loadConst(numConst.getN1());
	}
	
	@Override
	public void visit(Statement_return stmtRet) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(Statement_read stmtRead) {
		if(!stmtRead.getDesignator().obj.getType().equals(Tab.charType)) {
			Code.put(Code.read);
		}
		else {
			Code.put(Code.bread);
		}
		Code.store(stmtRead.getDesignator().obj);
	}
	
	 /* DESIGNATOR STATEMENTS */
	@Override
	public void visit(Choose_ds_a designAssign) {
		Code.store(designAssign.getDesignator().obj);
	}
	
	@Override
	public void visit(Choose_ds_p designMeth) {
		int offset = designMeth.getDesignator().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		
		if(designMeth.getDesignator().obj.getType() != Tab.noType) {
			Code.put(Code.pop);
		}
		
	}
	
	@Override
	public void visit(Choose_ds_i desgnIncrement) {
		if(desgnIncrement.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(desgnIncrement.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(desgnIncrement.getDesignator().obj);
	}
	
	@Override
	public void visit(Choose_ds_d desgnDecrement) {
		if(desgnDecrement.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(desgnDecrement.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(desgnDecrement.getDesignator().obj);
	}
	
	@Override
	public void visit(DesignatorStatement2 desgnUnion) {
		// TODO
		Code.load(desgnUnion.getDesignator().obj); // set0
		Code.loadConst(0); // set0 0
		Code.loadConst(0); // set0 0 0
		Code.put(Code.astore); // - | set0[0] = 0
		Code.load(desgnUnion.getDesignator().obj); // set0
		Code.load(desgnUnion.getDesignator1().obj); // set0 set1
		Code.load(desgnUnion.getDesignator2().obj); // set0-n set1-1 set2-2
		
		
		Code.put(Code.enter);
		Code.put(3);
		Code.put(4); // dodatna i-3
		
		// ZA SET1
		Code.put(Code.load_1); // set1
		Code.loadConst(0); // set1 0
		Code.put(Code.aload); // set1[0]
		Code.loadConst(0); // set1[0] 0
		Code.put(Code.store_3); // set1[0]  |  i = 0
		Code.put(Code.load_3); // set1[0] i
		
		// loop
		int pc3 = Code.pc;
		Code.putFalseJump(Code.gt, 0); // - | if(i > set1[0]) == true we jump to add an elem
		int pc4 = Code.pc - 2;
		Code.put(Code.load_n); //set0 
		Code.put(Code.load_1); // set0 set1
		
		Code.put(Code.load_3); // set0 set1 i
		Code.loadConst(1); // set0 set1 i 1
		Code.put(Code.add); // set0 set1 i+1
		Code.put(Code.store_3); // set0 set1 | i = i+1
		
		Code.put(Code.load_3); // set0 set1 i+1
		Code.put(Code.aload); // set0 set1[i+1]
		
		Code.put(Code.call);
		Code.put2(addMeth.getAdr() - Code.pc + 1);
		
		Code.put(Code.load_1); // set1
		Code.loadConst(0); // set1 0
		Code.put(Code.aload); //set1[0]
		Code.put(Code.load_3); //set1[0] i
		
		//fixap --> we add elem
		Code.putJump(pc3);
		Code.fixup(pc4);
		
		
		// ZA SET2
		Code.put(Code.load_2); // set2
		Code.loadConst(0); // set2 0
		Code.put(Code.aload); // set2[0]
		Code.loadConst(0); // set2[0] 0
		Code.put(Code.store_3); // set2[0]  |  i = 0
		Code.put(Code.load_3); // set2[0] i
		
		// loop
		int pc5 = Code.pc;
		Code.putFalseJump(Code.gt, 0); // - | if(i > set2[0]) == true we jump to add an elem
		int pc6 = Code.pc - 2;
		Code.put(Code.load_n); //set0 
		Code.put(Code.load_2); // set0 set2
		
		Code.put(Code.load_3); // set0 set2 i
		Code.loadConst(1); // set0 set2 i 1
		Code.put(Code.add); // set0 set2 i+1
		Code.put(Code.store_3); // set0 set2 | i = i+1
		
		Code.put(Code.load_3); // set0 set2 i+1
		Code.put(Code.aload); // set0 set2[i+1]
		
		Code.put(Code.call);
		Code.put2(addMeth.getAdr() - Code.pc + 1);
		
		Code.put(Code.load_2); // set2
		Code.loadConst(0); // set2 0
		Code.put(Code.aload); //set2[0]
		Code.put(Code.load_3); //set2[0] i
		
		//fixap --> we add elem
		Code.putJump(pc5);
		Code.fixup(pc6); // len
		
		Code.put(Code.exit);
	}
	
	@Override
	public void visit(ExprDesignator desigMap) {
		int addrF = desigMap.getDesignator().obj.getAdr();
		Code.loadConst(addrF); // f - n
		Code.load(desigMap.getDesignator1().obj); // array - 1
		
		Code.put(Code.enter);
		Code.put(2);
		Code.put(4); // dodatna i-2 rez -3
		
		Code.loadConst(0); // 0
		Code.put(Code.store_2); // - | i = 0
		Code.put(Code.load_1); // array
		Code.put(Code.arraylength); // len
		Code.put(Code.load_2); // len i
		
		// loop
		int pc3 = Code.pc;
		Code.putFalseJump(Code.gt, 0); // - | if(i > set1[0]) == true we jump to add an elem
		int pc4 = Code.pc - 2;
		Code.put(Code.load_n); // f
		Code.put(Code.load_1); // f arr
		Code.put(Code.load_2); // f arr i
		Code.put(Code.aload); // f arr[i]
		
		Code.put(Code.call);
		Code.put2(addrF - Code.pc + 1);
		
		Code.put(Code.load_3);// retval rez 
		Code.put(Code.add); // rez
		Code.put(Code.store_3);// - | rez = retval + rez
		Code.put(Code.pop); // skidam adresu fje ostaje posle call-a
		
		Code.put(Code.load_2); // i
		Code.loadConst(1); // i 1
		Code.put(Code.add); // i+1
		Code.put(Code.store_2); // - | i = i+1
		
		Code.put(Code.load_1); // array
		Code.put(Code.arraylength); // len
		Code.put(Code.load_2); // len i
		
		//fixap --> we add elem
		Code.putJump(pc3);
		Code.fixup(pc4);
		Code.put(Code.load_3); // rez
		Code.put(Code.exit);
		
	}
	
	/* FACTOR1 na stek */
	
	@Override
	public void visit(Factor1Square_node factMeth) {
		int offset = factMeth.getDesignator().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		
	}
	
	@Override
	public void visit(Factor1_num factNum) {
		Code.loadConst(factNum.getN1());
	}
	
	@Override
	public void visit(Factor1_char factChar) {
		Code.loadConst(factChar.getC1());
	}
	
	@Override
	public void visit(Factor1_bool factBool) {
		Code.loadConst(factBool.getB1());
	}
	
	@Override
	public void visit(Factor1Square_des factDes) {
		Code.load(factDes.getDesignator().obj);
	}
	
	@Override
	public void visit(Factor1_new factNew) {
		Code.put(Code.newarray);
		if(factNew.getType().struct.equals(Tab.charType)) {
			Code.put(0);
		}
		else {
			Code.put(1);
		}
	}
	
	@Override
	public void visit(DesignatorList arrName) {
		Code.load(arrName.obj);
	}
	
	/* OP na stek */
	
	@Override
	public void visit(AddopTermList_node addop) {
		if(addop.getAddop() instanceof Addop_pl) {
			Code.put(Code.add);
		}
		if(addop.getAddop() instanceof Addop_mi) {
			Code.put(Code.sub);
		}
	}
	
	@Override
	public void visit(MulopList_node mulop) {
		if(mulop.getMulop() instanceof Mulop_mu) {
			Code.put(Code.mul);
		}
		if(mulop.getMulop() instanceof Mulop_di) {
			Code.put(Code.div);
		}
		if(mulop.getMulop() instanceof Mulop_mo) {
			Code.put(Code.rem);
		}
	}
	
	
	@Override
	public void visit(Factor_minus factMin) {
		Code.put(Code.neg);
	}
	
	
	/* CondFact */
	private int relop = 0;
	
	private int retRelOp(Relop relop) {
		if(relop instanceof Relop_ee) {
			return Code.eq;
		}
		else if(relop instanceof Relop_ne) {
			return Code.ne;
		}
		else if(relop instanceof Relop_ge) {
			return Code.ge;
		}
		else if(relop instanceof Relop_gr) {
			return Code.gt;
		}
		else if(relop instanceof Relop_le) {
			return Code.le;
		}
		else if(relop instanceof Relop_ls) {
			return Code.lt;
		}
		else {
			return 0;
		}
	}
	
	private Stack<Integer> skip = new Stack<>();
	private Stack<Integer> skipCond = new Stack<>();
	private Stack<Integer> skipcond = new Stack<>();
	private Stack<Integer> skipelse = new Stack<>();
	
	private Stack<List<Integer>> breakStack = new Stack<>();
	private Stack<List<Integer>> continueStack = new Stack<>();
	
	@Override
	public void visit(CondFact condFact) {
		if(condFact.getRelopExprSquare() instanceof NoRelopExprSquare) {
			Code.loadConst(0);
			Code.putFalseJump(Code.ne, 0); //false
			skip.push(Code.pc - 2);
			//true
		}
		else if(condFact.getRelopExprSquare() instanceof RelopExprSquare_node){
			Code.putFalseJump(this.relop, 0); //false
			skip.push(Code.pc - 2);
			//true
		}

	}
	
	@Override
	public void visit(RelopExprSquare_node relop) {
		this.relop = retRelOp(relop.getRelop());
	}
	
	@Override
	public void visit(CondTerm condTerm) {
		Code.putJump(0); // true go to then
		skipCond.push(Code.pc - 2);
		//pop the false ones
		while(!skip.empty()) {
			Code.fixup(skip.pop());
		}
		// false
	}
	
	@Override
	public void visit(Condition cond) {
		// false
		Code.putJump(0); // false go to else
		skipcond.push(Code.pc - 2);
		//pop the false ones
		while(!skipCond.empty()) {
			Code.fixup(skipCond.pop());
		}
		//true
	}
	
	@Override
	public void visit(NoElseSquare noElse) {
		//true
		Code.fixup(skipcond.pop());
		// now false + true 
		
	}
	
	@Override
	public void visit(Else e) {
		// true
		Code.putJump(0); // true go to end of else
		skipelse.push(Code.pc - 2);
		Code.fixup(skipcond.pop());
		// false
	}
	
	@Override
	public void visit(ElseSquare_node elseNode) {
		// false
		Code.fixup(skipelse.pop());
		// true + false
	}
	
	// do while
	private Stack<Integer> doWhileStack = new Stack<>();
	
	@Override
	public void visit(StatementDO stmtDO) {
		doWhileStack.push(Code.pc);
		continueStack.push(new ArrayList<Integer>());
		breakStack.push(new ArrayList<Integer>());
	}
	
	@Override
	public void visit(Statement_do stmtDO) {
		Code.putJump(doWhileStack.pop());
		Code.fixup(skipcond.pop());
		//fixup break-a
		List<Integer> arr = breakStack.pop();
		while(!arr.isEmpty()) {
			Code.fixup(arr.remove(0));
		}
	}
	
	@Override
	public void visit(Statement_continue stmtBreak) {
		Code.putJump(0);
		continueStack.peek().add(Code.pc - 2);
	}
	
	@Override
	public void visit(Statement_break stmtBreak) {
		Code.putJump(0);
		breakStack.peek().add(Code.pc - 2);
	}
	
	@Override
	public void visit(StatementWhile stmtWhile) {
		//fixup continue-a
		List<Integer> arr = continueStack.pop();
		while(!arr.isEmpty()) {
			Code.fixup(arr.remove(0));
		}
	}
	
	
}


