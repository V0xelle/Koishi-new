/*     */ package Koishi.cards;
/*     */ import Koishi.actions.ForceIntentAction;
/*     */ import basemod.ReflectionHacks;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*     */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*     */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*     */ import com.megacrit.cardcrawl.monsters.EnemyMoveInfo;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ public abstract class AbstractIntentChangingCard extends AbstractDefaultCard {
/*     */   public IntentTypes intentType;
/*     */   
/*     */   public enum IntentTypes {
/*  16 */     ATTACK,
/*  17 */     NOT_ATTACK;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  22 */   public ArrayList<EnemyMoveInfo> enemyMoves = new ArrayList<>();
/*     */   public EnemyMoveInfo move;
/*     */   public EnemyMoveInfo nextMove;
/*     */   public AbstractMonster newTarget;
/*     */   public boolean intentRevert = false;
/*  27 */   public static long songID = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractIntentChangingCard(String id, String img, int cost, AbstractCard.CardType type, AbstractCard.CardColor color, AbstractCard.CardRarity rarity, AbstractCard.CardTarget target, IntentTypes intentType) {
/*  38 */     super(id, img, cost, type, color, rarity, target);
/*  39 */     this.intentType = intentType;
/*     */   }
/*     */ 
/*     */   
/*     */   public void calculateCardDamage(AbstractMonster mo) {
/*  44 */     super.calculateCardDamage(mo);
/*  45 */     if (this.target == AbstractCard.CardTarget.ALL_ENEMY) {
/*  46 */       if (this.newTarget == null) {
/*  47 */         ArrayList<AbstractMonster> monsters = (AbstractDungeon.getCurrRoom()).monsters.monsters;
/*  48 */         for (int i = 0; i < monsters.size(); i++) {
/*  49 */           AbstractMonster m = monsters.get(i);
/*  50 */           this.enemyMoves.add((EnemyMoveInfo)ReflectionHacks.getPrivate(m, AbstractMonster.class, "move"));
/*  51 */           if (!m.isDeadOrEscaped() && !m.halfDead) {
/*  52 */             this.newTarget = m;
/*     */ 
/*     */             
/*  55 */             int counter = AbstractDungeon.aiRng.counter;
/*  56 */             long seed0 = ((Long)ReflectionHacks.getPrivate(AbstractDungeon.aiRng.random, RandomXS128.class, "seed0")).longValue();
/*  57 */             long seed1 = ((Long)ReflectionHacks.getPrivate(AbstractDungeon.aiRng.random, RandomXS128.class, "seed1")).longValue();
/*     */             
/*  59 */             ForceIntentAction.previewNewIntent(this.newTarget, this.intentType);
/*     */             
/*  61 */             AbstractDungeon.aiRng.counter = counter;
/*  62 */             AbstractDungeon.aiRng.random.setState(seed0, seed1);
/*     */           } 
/*     */         } 
/*     */       } 
/*  66 */     } else if (this.target == AbstractCard.CardTarget.ENEMY && mo != null && 
/*  67 */       this.newTarget == null) {
/*  68 */       this.newTarget = mo;
/*  69 */       this.move = (EnemyMoveInfo)ReflectionHacks.getPrivate(mo, AbstractMonster.class, "move");
/*     */       
/*  71 */       int counter = AbstractDungeon.aiRng.counter;
/*  72 */       long seed0 = ((Long)ReflectionHacks.getPrivate(AbstractDungeon.aiRng.random, RandomXS128.class, "seed0")).longValue();
/*  73 */       long seed1 = ((Long)ReflectionHacks.getPrivate(AbstractDungeon.aiRng.random, RandomXS128.class, "seed1")).longValue();
/*     */       
/*  75 */       ForceIntentAction.previewNewIntent(this.newTarget, this.intentType);
/*     */       
/*  77 */       AbstractDungeon.aiRng.counter = counter;
/*  78 */       AbstractDungeon.aiRng.random.setState(seed0, seed1);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  83 */     this.intentRevert = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/*  88 */     super.update();
/*  89 */     if (this.target == AbstractCard.CardTarget.ALL_ENEMY) {
/*  90 */       if (this.newTarget != null && !this.intentRevert) {
/*  91 */         Iterator<AbstractMonster> iterator = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
/*  92 */         while (iterator.hasNext()) {
/*  93 */           AbstractMonster m = iterator.next();
/*  94 */           if (!m.isDeadOrEscaped() && !m.halfDead) {
/*  95 */             this.newTarget = m;
/*  96 */             AbstractDungeon.effectsQueue.add(new ForceIntentChangePreviewEffect(this.newTarget.intentHb.cX, this.newTarget.intentHb.cY, 0.75F, 1.75F));
/*     */           } 
/*     */         } 
/*     */       } 
/* 100 */     } else if (this.target == AbstractCard.CardTarget.ENEMY && 
/* 101 */       this.newTarget != null && !this.intentRevert) {
/* 102 */       AbstractDungeon.effectsQueue.add(new ForceIntentChangePreviewEffect(this.newTarget.intentHb.cX, this.newTarget.intentHb.cY, 0.75F, 1.75F));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 107 */     if (this.target == AbstractCard.CardTarget.ALL_ENEMY) {
/* 108 */       if (this.newTarget != null && this.intentRevert) {
/* 109 */         ArrayList<AbstractMonster> monsters = (AbstractDungeon.getCurrRoom()).monsters.monsters;
/* 110 */         for (int i = 0; i < monsters.size(); i++) {
/* 111 */           AbstractMonster m = monsters.get(i);
/* 112 */           if (!m.isDeadOrEscaped() && !m.halfDead) {
/* 113 */             this.newTarget = m;
/* 114 */             this.newTarget.moveHistory.remove(this.newTarget.moveHistory.size() - 1);
/* 115 */             if (this.newTarget.moveHistory.size() > 0) {
/* 116 */               this.newTarget.moveHistory.remove(this.newTarget.moveHistory.size() - 1);
/*     */             }
/*     */             
/* 119 */             EnemyMoveInfo move = this.enemyMoves.get(i);
/* 120 */             this.newTarget.setMove(move.nextMove, move.intent, move.baseDamage, move.multiplier, move.isMultiDamage);
/* 121 */             this.newTarget.createIntent();
/*     */             
/* 123 */             this.newTarget = null;
/*     */           } 
/*     */         } 
/* 126 */         this.enemyMoves.clear();
/*     */       } 
/* 128 */     } else if (this.target == AbstractCard.CardTarget.ENEMY && 
/* 129 */       this.newTarget != null && this.intentRevert) {
/*     */       
/* 131 */       this.newTarget.moveHistory.remove(this.newTarget.moveHistory.size() - 1);
/* 132 */       if (this.newTarget.moveHistory.size() > 0) {
/* 133 */         this.newTarget.moveHistory.remove(this.newTarget.moveHistory.size() - 1);
/*     */       }
/*     */       
/* 136 */       this.newTarget.setMove(this.move.nextMove, this.move.intent, this.move.baseDamage, this.move.multiplier, this.move.isMultiDamage);
/* 137 */       this.newTarget.createIntent();
/*     */       
/* 139 */       this.newTarget = null;
/*     */       
/* 141 */       this.move = null;
/*     */     } 
/*     */     
/* 144 */     this.intentRevert = true;
/*     */   }
/*     */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/AbstractIntentChangingCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */